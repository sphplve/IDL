
#ifndef __Hash_TABLE_H__
#define __Hash_TABLE_H__

#include "../../../xplatform/include/list.h"
#include "hashFunction.h"
#include "equalToFunction.h"

namespace AXP {
    // Key:结点的Key类型(只支持基本数据类型)
    // Value:结点的Value类型(只支持RefBase派生的子类)
    template <typename Key, class Value>
    class HashTable : public CObject
    {
    private:

        struct Node : public CObject
        {
            Key basicKey;
            Sp<ByteArray> stringKey;
            Sp<Value> value;
            Sp<Node> next;
        };

    public:

        // 迭代器
        class Iterator : public CObject
        {
        public:

            Boolean MoveNext()
            {
                if (mNextNode == NULL)
                    return FALSE;

                mCurrentNode = mNextNode;
                mNextNode = mCurrentNode->next;
                if (mNextNode == NULL) {
                    Int32 bucket = mHashTable->GetMapLocationByKey(mCurrentNode->basicKey);
                    if (bucket == -1)
                        return FALSE;

                    while (!mNextNode && ++bucket < mHashTable->mBuckets->GetCount()) {
                        Sp<Node> node = mHashTable->mBuckets->Get(bucket);
                        if (node != NULL)
                            mNextNode = node;
                    }
                }

                return (mCurrentNode != NULL);
            }

            Void Reset()
            {
                mCurrentNode = NULL;
                mNextNode = mHashTable->Begin();
            }

            Sp<Value> GetValue()
            {
                if (mCurrentNode)
                    return mCurrentNode->value;
                else
                    return NULL;
            }

            Key GetKey()
            {
                if (mCurrentNode)
                    return mCurrentNode->basicKey;
                else
                    return NULL;
            }

        private:

            explicit Iterator(
                IN CONST Sp<Node> & node,
                IN CONST Sp<HashTable> & table)
            {
                mCurrentNode = NULL;
                mNextNode = node;
                mHashTable = table;
            }

        private:

            FRIEND class HashTable;
            Sp<Node> mCurrentNode; // 当前的位置
            Sp<Node> mNextNode; // 下一个位置
            Sp<HashTable> mHashTable;
        };

    public:

        explicit HashTable(
            IN Int32 n)
        {
            InitializeBuckets(n);
        }

        HashTable(
            IN CONST HashTable & hashTable)
        {
            mNumElements = 0;
            CopyFrom(hashTable);
        }

        HashTable & operator = (
            IN CONST HashTable & hashTable)
        {
            if (&hashTable != this) {
                Clear();
                CopyFrom(hashTable);
            }

            return *this;
        }

        ~HashTable()
        {
            Clear();
        }

        // 总数
        Int32 Size() CONST
        {
            return mNumElements;
        }

        // 判断是否为空
        Boolean Empty() CONST
        {
            return Size() == 0;
        }

        STATIC Sp<HashTable> Clone(
            IN CONST Sp<HashTable> & hashTable)
        {
            if (hashTable == NULL)
                return NULL;

            return new HashTable(*hashTable);
        }
    public:

        // 插入操作, 不允许重复
        Boolean InsertUnique(
            IN CONST Key key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            // 获取待插入元素在Hashtable中的索引
            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                // 如果key重复, 在不进行插入, 并告知用户插入失败
                if (mEquals(node->basicKey, key))
                    return FALSE;
            }

            // 插入结点
            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 插入操作, 允许重复
        Boolean InsertEqual(
            IN CONST Key key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (mEquals(node->basicKey, key)) {
                    Sp<Node> tmp = NewNode(key, value);
                    if (tmp == NULL)
                        return FALSE;

                    if (!mValueList->PushBack(value))
                        return FALSE;

                    tmp->next = node->next;
                    node->next = tmp;
                    ++mNumElements;

                    return TRUE;
                }
            }

            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 查找指定key是否存在
        Boolean Contains(
            CONST Key key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first = NULL;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (mEquals(first->basicKey, key))
                        return TRUE;
                }
            }

            return FALSE;
        }

        // 返回key的个数
        Int32 ContainsKeyCount(
            IN CONST Key key) CONST
        {
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 result = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp != NULL) {
                for (Sp<Node> node = temp; node; node = node->next) {
                    if (mEquals(node->basicKey, key))
                        ++result;
                }
            }

            return result;
        }

        Sp<Value> GetValue(
            IN CONST Key key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (mEquals(first->basicKey, key))
                        return first->value;
                }
            }

            return NULL;
        }

        // 移除指定key的元素
        Int32 Remove(
            IN CONST Key key)
        {
            // 计算映射位置
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 erased = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp == NULL)
                return erased;

            Sp<Node> first = temp;

            // 开始查找并删除
            if (first != NULL) {
                Sp<Node> node = first;
                Sp<Node> nextNode = node->next;
                while (nextNode != NULL) {
                    if (mEquals(nextNode->basicKey, key)) {
                        node->next = nextNode->next;
                        mValueList->Detach(nextNode->value);
                        nextNode = node->next;
                        ++erased;
                        --mNumElements;
                    }
                    else {
                        node = nextNode;
                        nextNode = node->next;
                    }
                }

                if (mEquals(first->basicKey, key)) {
                    mBuckets->SetValue(n, first->next);
                    mValueList->Detach(first->value);
                    ++erased;
                    --mNumElements;
                }
            }

            return erased;
        }

        // 移除指定迭代器的元素
        Void Remove(
            IN CONST Sp<Iterator> & it)
        {
            if (Sp<Node> CONST p = it->mCurrentNode) {
                CONST Int32 n = GetMapLocationByKey(p->basicKey);
                Sp<Node> temp = mBuckets->Get(n);
                if (temp == NULL)
                    return;

                Sp<Node> node = temp;

                if (node == p) {
                    mBuckets->SetValue(n, node->next);
                    mValueList->Detach(node->value);
                    --mNumElements;
                }
                else {
                    Sp<Node> nextNode = node->next;
                    while (nextNode != NULL) {
                        if (nextNode == p) {
                            node->next = nextNode->next;
                            mValueList->Detach(nextNode->value);
                            --mNumElements;
                            break;
                        }
                        else {
                            node = nextNode;
                            nextNode = node->next;
                        }
                    }
                }
            }
        }

        // 调整Hashtable的容量
        Void ReSize(
            IN Int32 numElementsHint)
        {
            CONST Int32 old = mBuckets->GetCount();
            if (numElementsHint > old) {
                Sp<List<Node> > buckets = new List<Node>();

                for (Int32 i = 0; i < numElementsHint; i++)
                    buckets->PushBack(NULL);

                for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                    Sp<Node> first = mBuckets->Get(i);
                    Sp<Node> nextNode = NULL;

                    while (first != NULL) {
                        Int32 newBucket = GetMapLocationByKey(first->basicKey, numElementsHint);
                        nextNode = first->next;
                        Sp<Node> newNode = buckets->Get(newBucket);
                        first->next = newNode;
                        buckets->SetValue(newBucket, first);
                        first = nextNode;
                    }
                }

                mBuckets = buckets;
            }
        }

        // 清空Hashtable,但是不释放list的内存
        Void Clear()
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                while (node != NULL) {
                    Sp<Node> nextNode = node->next;
                    mValueList->Detach(node->value);
                    node = nextNode;
                }

                mBuckets->SetValue(i, NULL);
            }

            mValueList->Clear();
            mNumElements = 0;
        }

        Sp<List<Value> > GetValues()
        {
            return mValueList;
        }

        Sp<Iterator> GetIterator()
        {
            return new Iterator(Begin(), this);
        }

        Sp<Value> operator [](CONST Key key)
        {
            return GetValue(key);
        }

    private:

        // 预留空间,并进行初始化
        Void InitializeBuckets(
            IN Int32 n)
        {
            mValueList = new List<Value>;
            if (mValueList == NULL)
                return;

            mBuckets = new List<Node>();
            if (mBuckets == NULL)
                return;

            for (Int32 i = 0; i < n; i++)
                mBuckets->PushBack(NULL);

            mNumElements = 0;
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST Key key) CONST
        {
            return GetMapLocationByKey(key, mBuckets->GetCount());
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST Key key,
            Int32 n) CONST
        {
            return mHash(key) % n;
        }

        // 分配空间并进行构造
        Sp<Node> NewNode(
            IN CONST Key key,
            IN CONST Sp<Value> & value)
        {
            Sp<Node> node = new Node();
            if (node == NULL)
                return NULL;

            node->basicKey = key;
            node->value = value;
            node->next = NULL;

            return node;
        }

        // 复制HashTable
        Void CopyFrom(
            IN CONST HashTable & hashTable)
        {
            // 预留足够容量
            InitializeBuckets(hashTable.mBuckets->GetCount());

            // 开始copy操作
            for (Int32 i = 0; i < hashTable.mBuckets->GetCount(); ++i){
                if (Sp<Node> node = hashTable.mBuckets->Get(i)) {
                    Sp<Node> copy = NewNode(node->basicKey, node->value);
                    if (copy == NULL)
                        return;

                    if (!mValueList->PushBack(node->value))
                        return;

                    mBuckets->SetValue(i, copy);
                    for (Sp<Node> nextNode = node->next; nextNode != NULL; node = nextNode, nextNode = node->next) {
                        Sp<Node> copyNext = NewNode(node->basicKey, node->value);
                        if (copyNext == NULL)
                            return;

                        if (!mValueList->PushBack(node->value))
                            return;

                        copy->next = copyNext;
                        copy = copy->next;
                    }
                }
            }

            mNumElements = hashTable.mNumElements;
        }

        // 获取开始结点
        Sp<Node> Begin() CONST
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                if (node != NULL)
                    return node;
            }

            return NULL;
        }

    private:

        Sp<List<Node> > mBuckets;
        Sp<List<Value> > mValueList;
        Int32 mNumElements;
        Hash<Key> mHash;
        EqualTo<Key> mEquals;
    };

    template <class Value>
    class HashTable<PChar, Value> : public CObject
    {
    private:

        struct Node : public CObject
        {
            PChar basicKey;
            Sp<ByteArray> stringKey;
            Sp<Value> value;
            Sp<Node> next;
        };

    public:

        // 迭代器
        class Iterator : public CObject
        {
        public:

            Boolean MoveNext()
            {
                if (mNextNode == NULL)
                    return FALSE;

                mCurrentNode = mNextNode;
                mNextNode = mCurrentNode->next;
                if (mNextNode == NULL) {
                    if (mCurrentNode->stringKey == NULL)
                        return FALSE;

                    Int32 bucket = mHashTable->GetMapLocationByKey((PChar)mCurrentNode->stringKey->GetPayload());
                    if (bucket == -1)
                        return FALSE;

                    while (!mNextNode && ++bucket < mHashTable->mBuckets->GetCount()) {
                        Sp<Node> node = mHashTable->mBuckets->Get(bucket);
                        if (node != NULL)
                            mNextNode = node;
                    }
                }

                return (mCurrentNode != NULL);
            }

            Void Reset()
            {
                mCurrentNode = NULL;
                mNextNode = mHashTable->Begin();
            }

            Sp<Value> GetValue()
            {
                if (mCurrentNode)
                    return mCurrentNode->value;
                else
                    return NULL;
            }

            PChar GetKey()
            {
                if ((mCurrentNode != NULL) && (mCurrentNode->stringKey != NULL)) {
                    return (PChar)mCurrentNode->stringKey->GetPayload();
                }
                else
                    return NULL;
            }

        private:

            explicit Iterator(
                IN CONST Sp<Node> & node,
                IN CONST Sp<HashTable> & table)
            {
                mCurrentNode = NULL;
                mNextNode = node;
                mHashTable = table;
            }

        private:

            FRIEND class HashTable;
            Sp<Node> mCurrentNode; // 当前的位置
            Sp<Node> mNextNode; // 下一个位置
            Sp<HashTable> mHashTable;
        };

    public:

        explicit HashTable(
            IN Int32 n)
        {
            InitializeBuckets(n);
        }

        HashTable(
            IN CONST HashTable & hashTable)
        {
            mNumElements = 0;
            CopyFrom(hashTable);
        }

        HashTable & operator = (
            IN CONST HashTable & hashTable)
        {
            if (&hashTable != this) {
                Clear();
                CopyFrom(hashTable);
            }

            return *this;
        }

        ~HashTable()
        {
            Clear();
        }

        // 总数
        Int32 Size() CONST
        {
            return mNumElements;
        }

        // 判断是否为空
        Boolean Empty() CONST
        {
            return Size() == 0;
        }

    public:

        // 插入操作, 不允许重复
        Boolean InsertUnique(
            IN CONST PChar key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            // 获取待插入元素在Hashtable中的索引
            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                // 如果key重复, 在不进行插入, 并告知用户插入失败
                if (mEquals((PChar)node->stringKey->GetPayload(), key))
                    return FALSE;
            }

            // 插入结点
            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 插入操作, 允许重复
        Boolean InsertEqual(
            IN CONST PChar key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                if (mEquals((PChar)node->stringKey->GetPayload(), key)) {
                    Sp<Node> tmp = NewNode(key, value);
                    if (tmp == NULL)
                        return FALSE;

                    if (!mValueList->PushBack(value))
                        return FALSE;

                    tmp->next = node->next;
                    node->next = tmp;
                    ++mNumElements;

                    return TRUE;
                }
            }

            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 查找指定key是否存在
        Boolean Contains(
            CONST PChar key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first = NULL;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PChar)first->stringKey->GetPayload(), key))
                        return TRUE;
                }
            }

            return FALSE;
        }

        // 返回key的个数
        Int32 ContainsKeyCount(
            IN CONST PChar key) CONST
        {
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 result = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp != NULL) {
                for (Sp<Node> node = temp; node; node = node->next) {
                    if (node->stringKey == NULL)
                        continue;

                    if (mEquals((PChar)node->stringKey->GetPayload(), key))
                        ++result;
                }
            }

            return result;
        }

        Sp<Value> GetValue(
            IN CONST PChar key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PChar)first->stringKey->GetPayload(), key))
                        return first->value;
                }
            }

            return NULL;
        }

        // 移除指定key的元素
        Int32 Remove(
            IN CONST PChar key)
        {
            // 计算映射位置
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 erased = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp == NULL)
                return erased;

            Sp<Node> first = temp;

            // 开始查找并删除
            if (first != NULL) {
                Sp<Node> node = first;
                Sp<Node> nextNode = node->next;
                while (nextNode != NULL) {
                    if (nextNode->stringKey == NULL)
                        return erased;

                    if (mEquals((PChar)nextNode->stringKey->GetPayload(), key)) {
                        node->next = nextNode->next;
                        mValueList->Detach(nextNode->value);
                        nextNode = node->next;
                        ++erased;
                        --mNumElements;
                    }
                    else {
                        node = nextNode;
                        nextNode = node->next;
                    }
                }

                if (first->stringKey == NULL)
                    return erased;

                if (mEquals((PChar)first->stringKey->GetPayload(), key)) {
                    mBuckets->SetValue(n, first->next);
                    mValueList->Detach(first->value);
                    ++erased;
                    --mNumElements;
                }
            }

            return erased;
        }

        // 移除指定迭代器的元素
        Void Remove(
            IN CONST Sp<Iterator> & it)
        {
            if (it == NULL)
                return;

            if (Sp<Node> CONST p = it->mCurrentNode) {
                if (p->stringKey == NULL)
                    return;

                CONST Int32 n = GetMapLocationByKey((PChar)p->stringKey->GetPayload());
                Sp<Node> temp = mBuckets->Get(n);
                if (temp == NULL)
                    return;

                Sp<Node> node = temp;

                if (node == p) {
                    mBuckets->SetValue(n, node->next);
                    mValueList->Detach(node->value);
                    --mNumElements;
                }
                else {
                    Sp<Node> nextNode = node->next;
                    while (nextNode != NULL) {
                        if (nextNode == p) {
                            node->next = nextNode->next;
                            mValueList->Detach(nextNode->value);
                            --mNumElements;
                            break;
                        }
                        else {
                            node = nextNode;
                            nextNode = node->next;
                        }
                    }
                }
            }
        }

        // 调整Hashtable的容量
        Void ReSize(
            IN Int32 numElementsHint)
        {
            CONST Int32 old = mBuckets->GetCount();
            if (numElementsHint > old) {
                Sp<List<Node> > buckets = new List<Node>();

                for (Int32 i = 0; i < numElementsHint; i++)
                    buckets->PushBack(NULL);

                for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                    Sp<Node> first = mBuckets->Get(i);
                    Sp<Node> nextNode = NULL;

                    while (first != NULL) {
                        if (first->stringKey == NULL)
                            return;

                        Int32 newBucket = GetMapLocationByKey((PChar)first->stringKey->GetPayload(), numElementsHint);
                        nextNode = first->next;
                        Sp<Node> newNode = buckets->Get(newBucket);
                        first->next = newNode;
                        buckets->SetValue(newBucket, first);
                        first = nextNode;
                    }
                }

                mBuckets = buckets;
            }
        }

        // 清空Hashtable,但是不释放list的内存
        Void Clear()
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                while (node != NULL) {
                    Sp<Node> nextNode = node->next;
                    mValueList->Detach(node->value);
                    node = nextNode;
                }

                mBuckets->SetValue(i, NULL);
            }

            mValueList->Clear();
            mNumElements = 0;
        }

        Sp<List<Value> > GetValues()
        {
            return mValueList;
        }

        Sp<Iterator> GetIterator()
        {
            return new Iterator(Begin(), this);
        }

        Sp<Value> operator [](CONST PChar key)
        {
            return GetValue(key);
        }

    private:

        // 预留空间,并进行初始化
        Void InitializeBuckets(
            IN Int32 n)
        {
            mValueList = new List<Value>;
            if (mValueList == NULL)
                return;

            mBuckets = new List<Node>();
            if (mBuckets == NULL)
                return;

            for (Int32 i = 0; i < n; i++)
                mBuckets->PushBack(NULL);

            mNumElements = 0;
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PChar key) CONST
        {
            return GetMapLocationByKey(key, mBuckets->GetCount());
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PChar key,
            Int32 n) CONST
        {
            return mHash(key) % n;
        }

        // 分配空间并进行构造
        Sp<Node> NewNode(
            IN CONST PChar key,
            IN CONST Sp<Value> & value)
        {
            Sp<Node> node = new Node();
            if (node == NULL)
                return NULL;

            Int32 len = Strlen(key);
            node->stringKey = ByteArray::Create(len + 1);
            if (node->stringKey == NULL)
                return NULL;

            ARESULT ar = node->stringKey->Append((PByte)key, len);
            if (AFAILED(ar))
                return NULL;

            ar = node->stringKey->Append((PByte)"\0", 1);
            if (AFAILED(ar))
                return NULL;

            node->value = value;
            node->next = NULL;

            return node;
        }

        // 复制HashTable
        Void CopyFrom(
            IN CONST HashTable & hashTable)
        {
            // 预留足够容量
            InitializeBuckets(hashTable.mBuckets->GetCount());

            // 开始copy操作
            for (Int32 i = 0; i < hashTable.mBuckets->GetCount(); ++i){
                if (Sp<Node> node = hashTable.mBuckets->Get(i)) {
                    if (node->stringKey == NULL)
                        continue;

                    Sp<Node> copy = NewNode((PChar)node->stringKey->GetPayload(), node->value);
                    if (copy == NULL)
                        return;

                    if (!mValueList->PushBack(node->value))
                        return;

                    mBuckets->SetValue(i, copy);
                    for (Sp<Node> nextNode = node->next; nextNode != NULL; node = nextNode, nextNode = node->next) {
                        if (node->stringKey == NULL)
                            continue;

                        Sp<Node> copyNext = NewNode((PChar)node->stringKey->GetPayload(), node->value);
                        if (copyNext == NULL)
                            return;

                        if (!mValueList->PushBack(node->value))
                            return;

                        copy->next = copyNext;
                        copy = copy->next;
                    }
                }
            }

            mNumElements = hashTable.mNumElements;
        }

        // 获取开始结点
        Sp<Node> Begin() CONST
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                if (node != NULL)
                    return node;
            }

            return NULL;
        }

    private:

        Sp<List<Node> > mBuckets;
        Sp<List<Value> > mValueList;
        Int32 mNumElements;
        Hash<PChar> mHash;
        EqualTo<PChar> mEquals;
    };

    template <class Value>
    class HashTable<PWStr, Value> : public CObject
    {
    private:

        struct Node : public CObject
        {
            PWStr basicKey;
            Sp<ByteArray> stringKey;
            Sp<Value> value;
            Sp<Node> next;
        };

    public:

        // 迭代器
        class Iterator : public CObject
        {
        public:

            Boolean MoveNext()
            {
                if (mNextNode == NULL)
                    return FALSE;

                mCurrentNode = mNextNode;
                mNextNode = mCurrentNode->next;
                if (mNextNode == NULL) {
                    if (mCurrentNode->stringKey == NULL)
                        return FALSE;

                    Int32 bucket = mHashTable->GetMapLocationByKey((PWStr)mCurrentNode->stringKey->GetPayload());
                    if (bucket == -1)
                        return FALSE;

                    while (!mNextNode && ++bucket < mHashTable->mBuckets->GetCount()) {
                        Sp<Node> node = mHashTable->mBuckets->Get(bucket);
                        if (node != NULL)
                            mNextNode = node;
                    }
                }

                return (mCurrentNode != NULL);
            }

            Void Reset()
            {
                mCurrentNode = NULL;
                mNextNode = mHashTable->Begin();
            }

            Sp<Value> GetValue()
            {
                if (mCurrentNode)
                    return mCurrentNode->value;
                else
                    return NULL;
            }

            PWStr GetKey()
            {
                if ((mCurrentNode != NULL) && (mCurrentNode->stringKey != NULL)) {
                    return (PWStr)mCurrentNode->stringKey->GetPayload();
                }
                else
                    return NULL;
            }

        private:

            explicit Iterator(
                IN CONST Sp<Node> & node,
                IN CONST Sp<HashTable> & table)
            {
                mCurrentNode = NULL;
                mNextNode = node;
                mHashTable = table;
            }

        private:

            FRIEND class HashTable;
            Sp<Node> mCurrentNode; // 当前的位置
            Sp<Node> mNextNode; // 下一个位置
            Sp<HashTable> mHashTable;
        };

    public:

        explicit HashTable(
            IN Int32 n)
        {
            InitializeBuckets(n);
        }

        HashTable(
            IN CONST HashTable & hashTable)
        {
            mNumElements = 0;
            CopyFrom(hashTable);
        }

        HashTable & operator = (
            IN CONST HashTable & hashTable)
        {
            if (&hashTable != this) {
                Clear();
                CopyFrom(hashTable);
            }

            return *this;
        }

        ~HashTable()
        {
            Clear();
        }

        // 总数
        Int32 Size() CONST
        {
            return mNumElements;
        }

        // 判断是否为空
        Boolean Empty() CONST
        {
            return Size() == 0;
        }

    public:

        // 插入操作, 不允许重复
        Boolean InsertUnique(
            IN CONST PWStr key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            // 获取待插入元素在Hashtable中的索引
            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                // 如果key重复, 在不进行插入, 并告知用户插入失败
                if (mEquals((PWStr)node->stringKey->GetPayload(), key))
                    return FALSE;
            }

            // 插入结点
            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 插入操作, 允许重复
        Boolean InsertEqual(
            IN CONST PWStr key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                if (mEquals((PWStr)node->stringKey->GetPayload(), key)) {
                    Sp<Node> tmp = NewNode(key, value);
                    if (tmp == NULL)
                        return FALSE;

                    if (!mValueList->PushBack(value))
                        return FALSE;

                    tmp->next = node->next;
                    node->next = tmp;
                    ++mNumElements;

                    return TRUE;
                }
            }

            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 查找指定key是否存在
        Boolean Contains(
            CONST PWStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first = NULL;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PWStr)first->stringKey->GetPayload(), key))
                        return TRUE;
                }
            }

            return FALSE;
        }

        // 返回key的个数
        Int32 ContainsKeyCount(
            IN CONST PWStr key) CONST
        {
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 result = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp != NULL) {
                for (Sp<Node> node = temp; node; node = node->next) {
                    if (node->stringKey == NULL)
                        continue;

                    if (mEquals((PWStr)node->stringKey->GetPayload(), key))
                        ++result;
                }
            }

            return result;
        }

        Sp<Value> GetValue(
            IN CONST PWStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PWStr)first->stringKey->GetPayload(), key))
                        return first->value;
                }
            }

            return NULL;
        }

        // 移除指定key的元素
        Int32 Remove(
            IN CONST PWStr key)
        {
            // 计算映射位置
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 erased = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp == NULL)
                return erased;

            Sp<Node> first = temp;

            // 开始查找并删除
            if (first != NULL) {
                Sp<Node> node = first;
                Sp<Node> nextNode = node->next;
                while (nextNode != NULL) {
                    if (nextNode->stringKey == NULL)
                        return erased;

                    if (mEquals((PWStr)nextNode->stringKey->GetPayload(), key)) {
                        node->next = nextNode->next;
                        mValueList->Detach(nextNode->value);
                        nextNode = node->next;
                        ++erased;
                        --mNumElements;
                    }
                    else {
                        node = nextNode;
                        nextNode = node->next;
                    }
                }

                if (first->stringKey == NULL)
                    return erased;

                if (mEquals((PWStr)first->stringKey->GetPayload(), key)) {
                    mBuckets->SetValue(n, first->next);
                    mValueList->Detach(first->value);
                    ++erased;
                    --mNumElements;
                }
            }

            return erased;
        }

        // 移除指定迭代器的元素
        Void Remove(
            IN CONST Sp<Iterator> & it)
        {
            if (it == NULL)
                return;

            if (Sp<Node> CONST p = it->mCurrentNode) {
                if (p->stringKey == NULL)
                    return;

                CONST Int32 n = GetMapLocationByKey((PWStr)p->stringKey->GetPayload());
                Sp<Node> temp = mBuckets->Get(n);
                if (temp == NULL)
                    return;

                Sp<Node> node = temp;

                if (node == p) {
                    mBuckets->SetValue(n, node->next);
                    mValueList->Detach(node->value);
                    --mNumElements;
                }
                else {
                    Sp<Node> nextNode = node->next;
                    while (nextNode != NULL) {
                        if (nextNode == p) {
                            node->next = nextNode->next;
                            mValueList->Detach(nextNode->value);
                            --mNumElements;
                            break;
                        }
                        else {
                            node = nextNode;
                            nextNode = node->next;
                        }
                    }
                }
            }
        }

        // 调整Hashtable的容量
        Void ReSize(
            IN Int32 numElementsHint)
        {
            CONST Int32 old = mBuckets->GetCount();
            if (numElementsHint > old) {
                Sp<List<Node> > buckets = new List<Node>();

                for (Int32 i = 0; i < numElementsHint; i++)
                    buckets->PushBack(NULL);

                for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                    Sp<Node> first = mBuckets->Get(i);
                    Sp<Node> nextNode = NULL;

                    while (first != NULL) {
                        if (first->stringKey == NULL)
                            return;

                        Int32 newBucket = GetMapLocationByKey((PWStr)first->stringKey->GetPayload(), numElementsHint);
                        nextNode = first->next;
                        Sp<Node> newNode = buckets->Get(newBucket);
                        first->next = newNode;
                        buckets->SetValue(newBucket, first);
                        first = nextNode;
                    }
                }

                mBuckets = buckets;
            }
        }

        // 清空Hashtable,但是不释放list的内存
        Void Clear()
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                while (node != NULL) {
                    Sp<Node> nextNode = node->next;
                    mValueList->Detach(node->value);
                    node = nextNode;
                }

                mBuckets->SetValue(i, NULL);
            }

            mValueList->Clear();
            mNumElements = 0;
        }

        Sp<List<Value> > GetValues()
        {
            return mValueList;
        }

        Sp<Iterator> GetIterator()
        {
            return new Iterator(Begin(), this);
        }

        Sp<Value> operator [](CONST PWStr key)
        {
            return GetValue(key);
        }

    private:

        // 预留空间,并进行初始化
        Void InitializeBuckets(
            IN Int32 n)
        {
            mValueList = new List<Value>;
            if (mValueList == NULL)
                return;

            mBuckets = new List<Node>();
            if (mBuckets == NULL)
                return;

            for (Int32 i = 0; i < n; i++)
                mBuckets->PushBack(NULL);

            mNumElements = 0;
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PWStr key) CONST
        {
            return GetMapLocationByKey(key, mBuckets->GetCount());
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PWStr key,
            Int32 n) CONST
        {
            return mHash(key) % n;
        }

        // 分配空间并进行构造
        Sp<Node> NewNode(
            IN CONST PWStr key,
            IN CONST Sp<Value> & value)
        {
            Sp<Node> node = new Node();
            if (node == NULL)
                return NULL;

            Int32 len = Wcslen(key);
            node->stringKey = ByteArray::Create((len + 1) * sizeof(WChar));
            if (node->stringKey == NULL)
                return NULL;

            ARESULT ar = node->stringKey->Append((PByte)key, len * sizeof(WChar));
            if (AFAILED(ar))
                return NULL;

            ar = node->stringKey->Append((PByte)L"\0", sizeof(WChar));
            if (AFAILED(ar))
                return NULL;

            node->value = value;
            node->next = NULL;

            return node;
        }

        // 复制HashTable
        Void CopyFrom(
            IN CONST HashTable & hashTable)
        {
            // 预留足够容量
            InitializeBuckets(hashTable.mBuckets->GetCount());

            // 开始copy操作
            for (Int32 i = 0; i < hashTable.mBuckets->GetCount(); ++i){
                if (Sp<Node> node = hashTable.mBuckets->Get(i)) {
                    if (node->stringKey == NULL)
                        continue;

                    Sp<Node> copy = NewNode((PWStr)node->stringKey->GetPayload(), node->value);
                    if (copy == NULL)
                        return;

                    if (!mValueList->PushBack(node->value))
                        return;

                    mBuckets->SetValue(i, copy);
                    for (Sp<Node> nextNode = node->next; nextNode != NULL; node = nextNode, nextNode = node->next) {
                        if (node->stringKey == NULL)
                            continue;

                        Sp<Node> copyNext = NewNode((PWStr)node->stringKey->GetPayload(), node->value);
                        if (copyNext == NULL)
                            return;

                        if (!mValueList->PushBack(node->value))
                            return;

                        copy->next = copyNext;
                        copy = copy->next;
                    }
                }
            }

            mNumElements = hashTable.mNumElements;
        }

        // 获取开始结点
        Sp<Node> Begin() CONST
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                if (node != NULL)
                    return node;
            }

            return NULL;
        }

    private:

        Sp<List<Node> > mBuckets;
        Sp<List<Value> > mValueList;
        Int32 mNumElements;
        Hash<PWStr> mHash;
        EqualTo<PWStr> mEquals;
    };

    template <class Value>
    class HashTable<PCStr, Value> : public CObject
    {
    private:

        struct Node : public CObject
        {
            PCStr basicKey;
            Sp<ByteArray> stringKey;
            Sp<Value> value;
            Sp<Node> next;
        };

    public:

        // 迭代器
        class Iterator : public CObject
        {
        public:

            Boolean MoveNext()
            {
                if (mNextNode == NULL)
                    return FALSE;

                mCurrentNode = mNextNode;
                mNextNode = mCurrentNode->next;
                if (mNextNode == NULL) {
                    if (mCurrentNode->stringKey == NULL)
                        return FALSE;

                    Int32 bucket = mHashTable->GetMapLocationByKey((PCStr)mCurrentNode->stringKey->GetPayload());
                    if (bucket == -1)
                        return FALSE;

                    while (!mNextNode && ++bucket < mHashTable->mBuckets->GetCount()) {
                        Sp<Node> node = mHashTable->mBuckets->Get(bucket);
                        if (node != NULL)
                            mNextNode = node;
                    }
                }

                return (mCurrentNode != NULL);
            }

            Void Reset()
            {
                mCurrentNode = NULL;
                mNextNode = mHashTable->Begin();
            }

            Sp<Value> GetValue()
            {
                if (mCurrentNode)
                    return mCurrentNode->value;
                else
                    return NULL;
            }

            PCStr GetKey()
            {
                if ((mCurrentNode != NULL) && (mCurrentNode->stringKey != NULL)) {
                    return (PCStr)mCurrentNode->stringKey->GetPayload();
                }
                else
                    return NULL;
            }

        private:

            explicit Iterator(
                IN CONST Sp<Node> & node,
                IN CONST Sp<HashTable> & table)
            {
                mCurrentNode = NULL;
                mNextNode = node;
                mHashTable = table;
            }

        private:

            FRIEND class HashTable;
            Sp<Node> mCurrentNode; // 当前的位置
            Sp<Node> mNextNode; // 下一个位置
            Sp<HashTable> mHashTable;
        };

    public:

        explicit HashTable(
            IN Int32 n)
        {
            InitializeBuckets(n);
        }

        HashTable(
            IN CONST HashTable & hashTable)
        {
            mNumElements = 0;
            CopyFrom(hashTable);
        }

        HashTable & operator = (
            IN CONST HashTable & hashTable)
        {
            if (&hashTable != this) {
                Clear();
                CopyFrom(hashTable);
            }

            return *this;
        }

        ~HashTable()
        {
            Clear();
        }

        // 总数
        Int32 Size() CONST
        {
            return mNumElements;
        }

        // 判断是否为空
        Boolean Empty() CONST
        {
            return Size() == 0;
        }

    public:

        // 插入操作, 不允许重复
        Boolean InsertUnique(
            IN CONST PCStr key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            // 获取待插入元素在Hashtable中的索引
            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                // 如果key重复, 在不进行插入, 并告知用户插入失败
                if (mEquals((PCStr)node->stringKey->GetPayload(), key))
                    return FALSE;
            }

            // 插入结点
            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 插入操作, 允许重复
        Boolean InsertEqual(
            IN CONST PChar key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                if (mEquals((PCStr)node->stringKey->GetPayload(), key)) {
                    Sp<Node> tmp = NewNode(key, value);
                    if (tmp == NULL)
                        return FALSE;

                    if (!mValueList->PushBack(value))
                        return FALSE;

                    tmp->next = node->next;
                    node->next = tmp;
                    ++mNumElements;

                    return TRUE;
                }
            }

            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 查找指定key是否存在
        Boolean Contains(
            CONST PCStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first = NULL;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PCStr)first->stringKey->GetPayload(), key))
                        return TRUE;
                }
            }

            return FALSE;
        }

        // 返回key的个数
        Int32 ContainsKeyCount(
            IN CONST PCStr key) CONST
        {
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 result = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp != NULL) {
                for (Sp<Node> node = temp; node; node = node->next) {
                    if (node->stringKey == NULL)
                        continue;

                    if (mEquals((PCStr)node->stringKey->GetPayload(), key))
                        ++result;
                }
            }

            return result;
        }

        Sp<Value> GetValue(
            IN CONST PCStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PCStr)first->stringKey->GetPayload(), key))
                        return first->value;
                }
            }

            return NULL;
        }

        // 移除指定key的元素
        Int32 Remove(
            IN CONST PCStr key)
        {
            // 计算映射位置
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 erased = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp == NULL)
                return erased;

            Sp<Node> first = temp;

            // 开始查找并删除
            if (first != NULL) {
                Sp<Node> node = first;
                Sp<Node> nextNode = node->next;
                while (nextNode != NULL) {
                    if (nextNode->stringKey == NULL)
                        return erased;

                    if (mEquals((PCStr)nextNode->stringKey->GetPayload(), key)) {
                        node->next = nextNode->next;
                        mValueList->Detach(nextNode->value);
                        nextNode = node->next;
                        ++erased;
                        --mNumElements;
                    }
                    else {
                        node = nextNode;
                        nextNode = node->next;
                    }
                }

                if (first->stringKey == NULL)
                    return erased;

                if (mEquals((PCStr)first->stringKey->GetPayload(), key)) {
                    mBuckets->SetValue(n, first->next);
                    mValueList->Detach(first->value);
                    ++erased;
                    --mNumElements;
                }
            }

            return erased;
        }

        // 移除指定迭代器的元素
        Void Remove(
            IN CONST Sp<Iterator> & it)
        {
            if (it == NULL)
                return;

            if (Sp<Node> CONST p = it->mCurrentNode) {
                if (p->stringKey == NULL)
                    return;

                CONST Int32 n = GetMapLocationByKey((PCStr)p->stringKey->GetPayload());
                Sp<Node> temp = mBuckets->Get(n);
                if (temp == NULL)
                    return;

                Sp<Node> node = temp;

                if (node == p) {
                    mBuckets->SetValue(n, node->next);
                    mValueList->Detach(node->value);
                    --mNumElements;
                }
                else {
                    Sp<Node> nextNode = node->next;
                    while (nextNode != NULL) {
                        if (nextNode == p) {
                            node->next = nextNode->next;
                            mValueList->Detach(nextNode->value);
                            --mNumElements;
                            break;
                        }
                        else {
                            node = nextNode;
                            nextNode = node->next;
                        }
                    }
                }
            }
        }

        // 调整Hashtable的容量
        Void ReSize(
            IN Int32 numElementsHint)
        {
            CONST Int32 old = mBuckets->GetCount();
            if (numElementsHint > old) {
                Sp<List<Node> > buckets = new List<Node>();

                for (Int32 i = 0; i < numElementsHint; i++)
                    buckets->PushBack(NULL);

                for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                    Sp<Node> first = mBuckets->Get(i);
                    Sp<Node> nextNode = NULL;

                    while (first != NULL) {
                        if (first->stringKey == NULL)
                            return;

                        Int32 newBucket = GetMapLocationByKey((PCStr)first->stringKey->GetPayload(), numElementsHint);
                        nextNode = first->next;
                        Sp<Node> newNode = buckets->Get(newBucket);
                        first->next = newNode;
                        buckets->SetValue(newBucket, first);
                        first = nextNode;
                    }
                }

                mBuckets = buckets;
            }
        }

        // 清空Hashtable,但是不释放list的内存
        Void Clear()
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                while (node != NULL) {
                    Sp<Node> nextNode = node->next;
                    mValueList->Detach(node->value);
                    node = nextNode;
                }

                mBuckets->SetValue(i, NULL);
            }

            mValueList->Clear();
            mNumElements = 0;
        }

        Sp<List<Value> > GetValues()
        {
            return mValueList;
        }

        Sp<Iterator> GetIterator()
        {
            return new Iterator(Begin(), this);
        }

        Sp<Value> operator [](CONST PChar key)
        {
            return GetValue(key);
        }

    private:

        // 预留空间,并进行初始化
        Void InitializeBuckets(
            IN Int32 n)
        {
            mValueList = new List<Value>;
            if (mValueList == NULL)
                return;

            mBuckets = new List<Node>();
            if (mBuckets == NULL)
                return;

            for (Int32 i = 0; i < n; i++)
                mBuckets->PushBack(NULL);

            mNumElements = 0;
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PCStr key) CONST
        {
            return GetMapLocationByKey(key, mBuckets->GetCount());
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PCStr key,
            Int32 n) CONST
        {
            return mHash(key) % n;
        }

        // 分配空间并进行构造
        Sp<Node> NewNode(
            IN CONST PCStr key,
            IN CONST Sp<Value> & value)
        {
            Sp<Node> node = new Node();
            if (node == NULL)
                return NULL;

            Int32 len = Strlen(key);
            node->stringKey = ByteArray::Create(len + 1);
            if (node->stringKey == NULL)
                return NULL;

            ARESULT ar = node->stringKey->Append((PByte)key, len);
            if (AFAILED(ar))
                return NULL;

            ar = node->stringKey->Append((PByte)"\0", 1);
            if (AFAILED(ar))
                return NULL;

            node->value = value;
            node->next = NULL;

            return node;
        }

        // 复制HashTable
        Void CopyFrom(
            IN CONST HashTable & hashTable)
        {
            // 预留足够容量
            InitializeBuckets(hashTable.mBuckets->GetCount());

            // 开始copy操作
            for (Int32 i = 0; i < hashTable.mBuckets->GetCount(); ++i){
                if (Sp<Node> node = hashTable.mBuckets->Get(i)) {
                    if (node->stringKey == NULL)
                        continue;

                    Sp<Node> copy = NewNode((PCStr)node->stringKey->GetPayload(), node->value);
                    if (copy == NULL)
                        return;

                    if (!mValueList->PushBack(node->value))
                        return;

                    mBuckets->SetValue(i, copy);
                    for (Sp<Node> nextNode = node->next; nextNode != NULL; node = nextNode, nextNode = node->next) {
                        if (node->stringKey == NULL)
                            continue;

                        Sp<Node> copyNext = NewNode((PCStr)node->stringKey->GetPayload(), node->value);
                        if (copyNext == NULL)
                            return;

                        if (!mValueList->PushBack(node->value))
                            return;

                        copy->next = copyNext;
                        copy = copy->next;
                    }
                }
            }

            mNumElements = hashTable.mNumElements;
        }

        // 获取开始结点
        Sp<Node> Begin() CONST
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                if (node != NULL)
                    return node;
            }

            return NULL;
        }

    private:

        Sp<List<Node> > mBuckets;
        Sp<List<Value> > mValueList;
        Int32 mNumElements;
        Hash<PCStr> mHash;
        EqualTo<PCStr> mEquals;
    };

    template <class Value>
    class HashTable<PCWStr, Value> : public CObject
    {
    private:

        struct Node : public CObject
        {
            PCWStr basicKey;
            Sp<ByteArray> stringKey;
            Sp<Value> value;
            Sp<Node> next;
        };

    public:

        // 迭代器
        class Iterator : public CObject
        {
        public:

            Boolean MoveNext()
            {
                if (mNextNode == NULL)
                    return FALSE;

                mCurrentNode = mNextNode;
                mNextNode = mCurrentNode->next;
                if (mNextNode == NULL) {
                    if (mCurrentNode->stringKey == NULL)
                        return FALSE;

                    Int32 bucket = mHashTable->GetMapLocationByKey((PCWStr)mCurrentNode->stringKey->GetPayload());
                    if (bucket == -1)
                        return FALSE;

                    while (!mNextNode && ++bucket < mHashTable->mBuckets->GetCount()) {
                        Sp<Node> node = mHashTable->mBuckets->Get(bucket);
                        if (node != NULL)
                            mNextNode = node;
                    }
                }

                return (mCurrentNode != NULL);
            }

            Void Reset()
            {
                mCurrentNode = NULL;
                mNextNode = mHashTable->Begin();
            }

            Sp<Value> GetValue()
            {
                if (mCurrentNode)
                    return mCurrentNode->value;
                else
                    return NULL;
            }

            PCWStr GetKey()
            {
                if ((mCurrentNode != NULL) && (mCurrentNode->stringKey != NULL)) {
                    return (PCWStr)mCurrentNode->stringKey->GetPayload();
                }
                else
                    return NULL;
            }

        private:

            explicit Iterator(
                IN CONST Sp<Node> & node,
                IN CONST Sp<HashTable> & table)
            {
                mCurrentNode = NULL;
                mNextNode = node;
                mHashTable = table;
            }

        private:

            FRIEND class HashTable;
            Sp<Node> mCurrentNode; // 当前的位置
            Sp<Node> mNextNode; // 下一个位置
            Sp<HashTable> mHashTable;
        };

    public:

        explicit HashTable(
            IN Int32 n)
        {
            InitializeBuckets(n);
        }

        HashTable(
            IN CONST HashTable & hashTable)
        {
            mNumElements = 0;
            CopyFrom(hashTable);
        }

        HashTable & operator = (
            IN CONST HashTable & hashTable)
        {
            if (&hashTable != this) {
                Clear();
                CopyFrom(hashTable);
            }

            return *this;
        }

        ~HashTable()
        {
            Clear();
        }

        // 总数
        Int32 Size() CONST
        {
            return mNumElements;
        }

        // 判断是否为空
        Boolean Empty() CONST
        {
            return Size() == 0;
        }

    public:

        // 插入操作, 不允许重复
        Boolean InsertUnique(
            IN CONST PCWStr key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            // 获取待插入元素在Hashtable中的索引
            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                // 如果key重复, 在不进行插入, 并告知用户插入失败
                if (mEquals((PCWStr)node->stringKey->GetPayload(), key))
                    return FALSE;
            }

            // 插入结点
            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 插入操作, 允许重复
        Boolean InsertEqual(
            IN CONST PCWStr key,
            IN CONST Sp<Value> & value)
        {
            ReSize(mNumElements + 1);

            CONST Int32 n = GetMapLocationByKey(key);
            if (mBuckets->GetCount() <= n)
                return FALSE;

            Sp<Node> temp = mBuckets->Get(n);
            Sp<Node> first = temp;
            for (Sp<Node> node = first; node != NULL; node = node->next) {
                if (node->stringKey == NULL)
                    continue;

                if (mEquals((PCWStr)node->stringKey->GetPayload(), key)) {
                    Sp<Node> tmp = NewNode(key, value);
                    if (tmp == NULL)
                        return FALSE;

                    if (!mValueList->PushBack(value))
                        return FALSE;

                    tmp->next = node->next;
                    node->next = tmp;
                    ++mNumElements;

                    return TRUE;
                }
            }

            Sp<Node> tmp = NewNode(key, value);
            if (tmp == NULL)
                return FALSE;

            if (!mValueList->PushBack(value))
                return FALSE;

            tmp->next = first;
            mBuckets->SetValue(n, tmp);
            ++mNumElements;

            return TRUE;
        }

        // 查找指定key是否存在
        Boolean Contains(
            CONST PCWStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first = NULL;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PCWStr)first->stringKey->GetPayload(), key))
                        return TRUE;
                }
            }

            return FALSE;
        }

        // 返回key的个数
        Int32 ContainsKeyCount(
            IN CONST PCWStr key) CONST
        {
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 result = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp != NULL) {
                for (Sp<Node> node = temp; node; node = node->next) {
                    if (node->stringKey == NULL)
                        continue;

                    if (mEquals((PCWStr)node->stringKey->GetPayload(), key))
                        ++result;
                }
            }

            return result;
        }

        Sp<Value> GetValue(
            IN CONST PCWStr key)
        {
            Int32 n = GetMapLocationByKey(key);
            Sp<Node> first;
            Sp<Node> node = mBuckets->Get(n);
            if (node != NULL) {
                for (first = node; first != NULL; first = first->next) {
                    if (first->stringKey == NULL)
                        continue;

                    if (mEquals((PCWStr)first->stringKey->GetPayload(), key))
                        return first->value;
                }
            }

            return NULL;
        }

        // 移除指定key的元素
        Int32 Remove(
            IN CONST PCWStr key)
        {
            // 计算映射位置
            CONST Int32 n = GetMapLocationByKey(key);
            Int32 erased = 0;
            Sp<Node> temp = mBuckets->Get(n);
            if (temp == NULL)
                return erased;

            Sp<Node> first = temp;

            // 开始查找并删除
            if (first != NULL) {
                Sp<Node> node = first;
                Sp<Node> nextNode = node->next;
                while (nextNode != NULL) {
                    if (nextNode->stringKey == NULL)
                        return erased;

                    if (mEquals((PCWStr)nextNode->stringKey->GetPayload(), key)) {
                        node->next = nextNode->next;
                        mValueList->Detach(nextNode->value);
                        nextNode = node->next;
                        ++erased;
                        --mNumElements;
                    }
                    else {
                        node = nextNode;
                        nextNode = node->next;
                    }
                }

                if (first->stringKey == NULL)
                    return erased;

                if (mEquals((PCWStr)first->stringKey->GetPayload(), key)) {
                    mBuckets->SetValue(n, first->next);
                    mValueList->Detach(first->value);
                    ++erased;
                    --mNumElements;
                }
            }

            return erased;
        }

        // 移除指定迭代器的元素
        Void Remove(
            IN CONST Sp<Iterator> & it)
        {
            if (it == NULL)
                return;

            if (Sp<Node> CONST p = it->mCurrentNode) {
                if (p->stringKey == NULL)
                    return;

                CONST Int32 n = GetMapLocationByKey((PCWStr)p->stringKey->GetPayload());
                Sp<Node> temp = mBuckets->Get(n);
                if (temp == NULL)
                    return;

                Sp<Node> node = temp;

                if (node == p) {
                    mBuckets->SetValue(n, node->next);
                    mValueList->Detach(node->value);
                    --mNumElements;
                }
                else {
                    Sp<Node> nextNode = node->next;
                    while (nextNode != NULL) {
                        if (nextNode == p) {
                            node->next = nextNode->next;
                            mValueList->Detach(nextNode->value);
                            --mNumElements;
                            break;
                        }
                        else {
                            node = nextNode;
                            nextNode = node->next;
                        }
                    }
                }
            }
        }

        // 调整Hashtable的容量
        Void ReSize(
            IN Int32 numElementsHint)
        {
            CONST Int32 old = mBuckets->GetCount();
            if (numElementsHint > old) {
                Sp<List<Node> > buckets = new List<Node>();

                for (Int32 i = 0; i < numElementsHint; i++)
                    buckets->PushBack(NULL);

                for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                    Sp<Node> first = mBuckets->Get(i);
                    Sp<Node> nextNode = NULL;

                    while (first != NULL) {
                        if (first->stringKey == NULL)
                            return;

                        Int32 newBucket = GetMapLocationByKey((PCWStr)first->stringKey->GetPayload(), numElementsHint);
                        nextNode = first->next;
                        Sp<Node> newNode = buckets->Get(newBucket);
                        first->next = newNode;
                        buckets->SetValue(newBucket, first);
                        first = nextNode;
                    }
                }

                mBuckets = buckets;
            }
        }

        // 清空Hashtable,但是不释放list的内存
        Void Clear()
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                while (node != NULL) {
                    Sp<Node> nextNode = node->next;
                    mValueList->Detach(node->value);
                    node = nextNode;
                }

                mBuckets->SetValue(i, NULL);
            }

            mValueList->Clear();
            mNumElements = 0;
        }

        Sp<List<Value> > GetValues()
        {
            return mValueList;
        }

        Sp<Iterator> GetIterator()
        {
            return new Iterator(Begin(), this);
        }

        Sp<Value> operator [](CONST PCWStr key)
        {
            return GetValue(key);
        }

    private:

        // 预留空间,并进行初始化
        Void InitializeBuckets(
            IN Int32 n)
        {
            mValueList = new List<Value>;
            if (mValueList == NULL)
                return;

            mBuckets = new List<Node>();
            if (mBuckets == NULL)
                return;

            for (Int32 i = 0; i < n; i++)
                mBuckets->PushBack(NULL);

            mNumElements = 0;
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PCWStr key) CONST
        {
            return GetMapLocationByKey(key, mBuckets->GetCount());
        }

        // 通过Key获取映射位置
        Int32 GetMapLocationByKey(
            IN CONST PCWStr key,
            Int32 n) CONST
        {
            return mHash(key) % n;
        }

        // 分配空间并进行构造
        Sp<Node> NewNode(
            IN CONST PCWStr key,
            IN CONST Sp<Value> & value)
        {
            Sp<Node> node = new Node();
            if (node == NULL)
                return NULL;

            Int32 len = Wcslen(key);
            node->stringKey = ByteArray::Create((len + 1) * sizeof(WChar));
            if (node->stringKey == NULL)
                return NULL;

            ARESULT ar = node->stringKey->Append((PByte)key, len * sizeof(WChar));
            if (AFAILED(ar))
                return NULL;

            ar = node->stringKey->Append((PByte)L"\0", sizeof(WChar));
            if (AFAILED(ar))
                return NULL;

            node->value = value;
            node->next = NULL;

            return node;
        }

        // 复制HashTable
        Void CopyFrom(
            IN CONST HashTable & hashTable)
        {
            // 预留足够容量
            InitializeBuckets(hashTable.mBuckets->GetCount());

            // 开始copy操作
            for (Int32 i = 0; i < hashTable.mBuckets->GetCount(); ++i){
                if (Sp<Node> node = hashTable.mBuckets->Get(i)) {
                    if (node->stringKey == NULL)
                        continue;

                    Sp<Node> copy = NewNode((PCWStr)node->stringKey->GetPayload(), node->value);
                    if (copy == NULL)
                        return;

                    if (!mValueList->PushBack(node->value))
                        return;

                    mBuckets->SetValue(i, copy);
                    for (Sp<Node> nextNode = node->next; nextNode != NULL; node = nextNode, nextNode = node->next) {
                        if (node->stringKey == NULL)
                            continue;

                        Sp<Node> copyNext = NewNode((PCWStr)node->stringKey->GetPayload(), node->value);
                        if (copyNext == NULL)
                            return;

                        if (!mValueList->PushBack(node->value))
                            return;

                        copy->next = copyNext;
                        copy = copy->next;
                    }
                }
            }

            mNumElements = hashTable.mNumElements;
        }

        // 获取开始结点
        Sp<Node> Begin() CONST
        {
            for (Int32 i = 0; i < mBuckets->GetCount(); i++) {
                Sp<Node> node = mBuckets->Get(i);
                if (node != NULL)
                    return node;
            }

            return NULL;
        }

    private:

        Sp<List<Node> > mBuckets;
        Sp<List<Value> > mValueList;
        Int32 mNumElements;
        Hash<PCWStr> mHash;
        EqualTo<PCWStr> mEquals;
    };
} // namespace AXP

#endif // __Hash_TABLE_H__

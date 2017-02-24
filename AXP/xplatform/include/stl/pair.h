
#ifndef __PAIR_H__
#define __PAIR_H__

namespace AXP {
    // Key:           结点的Key类型(只支持基本数据类型)
    // Value:         结点的Value类型(只支持RefBase派生的子类)
    template <class Key, class Value>
    class Pair
    {
    public:

        Pair()
        {
            mValue = NULL;
        }

        Pair(CONST Key a, CONST Sp<Value> & b)
        {
            mKey = a;
            mValue = b;
        }

        Pair(CONST Pair<Key, Value>& p)
        {
            mKey = p.mKey;
            mValue = p.mValue;
            if (mValue)
                mValue->AddRef();
        }

        Pair<Key, Value> & operator = (CONST Pair<Key, Value>& right)
        {
            mKey = right.mKey;
            mValue = right.mValue;

            return (*this);
        }

        Key GetKey()
        {
            return mKey;
        }

        CONST Key GetKey() CONST
        {
            return mKey;
        }

        Sp<Value> GetValue()
        {
            return mValue;
        }

        CONST Sp<Value> GetValue() CONST
        {
            return mValue;
        }

    public:

        Key mKey;
        Sp<Value> mValue;
    };
} // namespace AXP

#endif // __PAIR_H__

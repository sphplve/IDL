//
//  Parcel.cpp
//  CommAnalyzerCore
//
//  Created by zhanwenshu on 14-7-31.
//  Copyright (c) 2014年 Liu Alex. All rights reserved.
//

#include <stdio.h>
#include "../include/Parcel.h"
#include "../include/byteOrder.h"

namespace AXP {
    CParcel::CParcel()
    {
        mStream = new MemoryStream<PARCEL_BUFFER_DEFAULT_LENGTH>;
        if (mStream == NULL)
            return;

        mIsLittleEndian = AXP_LITTLE_ENDIAN;
        Write(mIsLittleEndian);
    }

    CParcel::CParcel(
        IN CONST Sp<MemoryStream<PARCEL_BUFFER_DEFAULT_LENGTH> > & stream)
    {
        mStream = stream;
    }

    ARESULT CParcel::Reset()
    {
        if (mStream == NULL)
            return AE_FAIL;

        mStream->SetPosition(0);
        if (AFAILED(Read(mIsLittleEndian)))
            return AE_FAIL;

        return AS_OK;
    }

    ARESULT CParcel::Reset(
        IN PCByte buffer,
        IN CONST Int64 length)
    {
        if (mStream == NULL)
            return AE_FAIL;

        mStream->SetPosition(0);
        if (!mStream->Write(buffer, length))
            return AE_OUTOFMEMORY;

        mStream->SetPosition(0);
        if (AFAILED(Read(mIsLittleEndian)))
            return AE_FAIL;

        return AS_OK;
    }

    PCByte CParcel::GetPayload()
    {
        if (mStream == NULL)
            return NULL;
        else
            return mStream->GetPayload();
    }

    ARESULT CParcel::Read(
        INOUT Int8 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Int8), sizeof(Int8)))
            return AE_OUTOFMEMORY;

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT UInt8 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(UInt8), sizeof(UInt8)))
            return AE_OUTOFMEMORY;

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Int16 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Int16), sizeof(Int16)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
            UInt16 temp = (UInt16)value;
            temp = SWAP_16(temp);
            value = (Int16)temp;
        }

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT UInt16 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(UInt16), sizeof(UInt16)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
            value = SWAP_16(value);

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Int32 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Int32), sizeof(Int32)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
            UInt32 temp = (UInt32)value;
            temp = SWAP_32(temp);
            value = (Int32)temp;
        }

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT UInt32 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(UInt32), sizeof(UInt32)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
            value = SWAP_32(value);

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Int64 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Int64), sizeof(Int64)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
            UInt64 temp = (UInt64)value;
            temp = SWAP_64(temp);
            value = (Int64)temp;
        }

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT UInt64 & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(UInt64), sizeof(UInt64)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
            value = SWAP_64(value);

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Float & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Float), sizeof(Float)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
            UInt32 temp = (UInt32)value;
            temp = SWAP_32(temp);
            value = (Float)temp;
        }

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Double & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Read(
            (PByte)&value, sizeof(Double), sizeof(Double)))
            return AE_OUTOFMEMORY;

        if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
            UInt64 temp = (UInt64)value;
            temp = SWAP_64(temp);
            value = (Double)temp;
        }

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Sp<ByteArray> & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        Int32 length;
        ARESULT ar = Read(length);
        if (AFAILED(ar))
            return ar;

        if (length == 0) {
            value = NULL;
            return AS_OK;
        }

        PStr buffer = (PStr)malloc(length);
        if (!buffer)
            return AE_OUTOFMEMORY;

        if (!mStream->Read((PByte)buffer, length, length)) {
            free(buffer);
            return AE_OUTOFMEMORY;
        }

        Sp<ByteArray> array = ByteArray::Create(length);
        if (array == NULL) {
            free(buffer);
            return AE_OUTOFMEMORY;
        }

        if (AFAILED(array->Append((PCByte)buffer, length))) {
            free(buffer);
            return AE_OUTOFMEMORY;
        }

        value = array;
        free(buffer);

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Sp<List<ByteArray> > & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        Int32 count;
        ARESULT ar = Read(count);
        if (AFAILED(ar))
            return ar;

        if (count == 0) {
            value = NULL;
            return AS_OK;
        }

        Sp<List<ByteArray> > list = new List<ByteArray>();
        if (list == NULL)
            return AE_OUTOFMEMORY;

        Sp<ByteArray> obj;
        for (Int32 i = 0; i < count; i++) {
            Read(obj);
            if (obj == NULL)
                return AE_OUTOFMEMORY;

            if (!list->PushBack(obj))
                return AE_OUTOFMEMORY;
        }

        value = list;

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Sp<String> & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        Int32 length;
        ARESULT ar = Read(length);
        if (AFAILED(ar))
            return ar;

        if (length == 0) {
            value = NULL;
            return AS_OK;
        }

        PStr buffer = (PStr)malloc(length);
        if (!buffer)
            return AE_OUTOFMEMORY;

        if (!mStream->Read((PByte)buffer, length, length)) {
            free(buffer);
            return AE_OUTOFMEMORY;
        }

        Sp<String> string = String::Create(
            (PCByte)buffer, sizeof(Char), length, EncodingType_UTF8);
        free(buffer);
        if (string == NULL)
            return AE_OUTOFMEMORY;

        value = string;

        return AS_OK;
    }

    ARESULT CParcel::Read(
        INOUT Sp<List<String> > & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        Int32 count;
        ARESULT ar = Read(count);
        if (AFAILED(ar))
            return ar;

        if (count == 0) {
            value = NULL;
            return AS_OK;
        }

        Sp<List<String> > list = new List<String>();
        if (list == NULL)
            return AE_OUTOFMEMORY;

        Sp<String> obj;
        for (Int32 i = 0; i < count; i++) {
            Read(obj);
            if (obj == NULL)
                return AE_OUTOFMEMORY;

            if (!list->PushBack(obj))
                return AE_OUTOFMEMORY;
        }

        value = list;

        return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Int8 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Int8)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST UInt8 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(UInt8)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Int16 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Int16)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST UInt16 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(UInt16)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Int32 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Int32)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST UInt32 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(UInt32)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Int64 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Int64)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST UInt64 value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(UInt64)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Float value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Float)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Double value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (!mStream->Write((PCByte)&value, sizeof(Double)))
            return AE_OUTOFMEMORY;
        else
            return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Sp<ByteArray> & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (value == NULL)
            return Write(0);

        Int32 length = value->GetUsed();
        ARESULT ar = Write(length);
        if (AFAILED(ar))
            return ar;

        if (!mStream->Write(value->GetPayload(), length))
            return AE_OUTOFMEMORY;

        return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Sp<List<ByteArray> > & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (value == NULL)
            return Write(0);

        ARESULT ar = Write(value->GetCount());
        if (AFAILED(ar))
            return ar;

        Foreach(ByteArray, obj, value) {
            ar = Write(obj);
            if (AFAILED(ar))
                return ar;
        }

        return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Sp<String> & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (value == NULL)
            return Write(0);

        Sp<ByteArray> ba = value->GetBytes();
        if (ba == NULL)
            return AE_OUTOFMEMORY;

        Int32 length = ba->GetUsed();
        if (length == 0)
            return Write(0);

        length = length - 1;
        ARESULT ar = Write(length);
        if (AFAILED(ar))
            return ar;

        if (!mStream->Write(ba->GetPayload(), length))
            return AE_OUTOFMEMORY;

        return AS_OK;
    }

    ARESULT CParcel::Write(
        IN CONST Sp<List<String> > & value)
    {
        if (mStream == NULL)
            return AE_FAIL;

        if (value == NULL)
            return Write(0);

        ARESULT ar = Write(value->GetCount());
        if (AFAILED(ar))
            return ar;

        Foreach(String, obj, value) {
            ar = Write(obj);
            if (AFAILED(ar))
                return ar;
        }

        return AS_OK;
    }
} // namespace AXP

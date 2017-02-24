//
//  Parcel.cpp
//  CommAnalyzerCore
//
//  Created by zhanwenshu on 14-7-31.
//  Copyright (c) 2014年 Liu Alex. All rights reserved.
//

#include <stdio.h>
#include "../../include/Common/Parcel.h"  
#include "../../../xplatform/include/byteOrder.h"

CParcel::CParcel()
{
    mStream = new AXP::MemoryBuffer<PARCEL_BUFFER_DEFAULT_LENGTH>;
    if (!mStream)
        return;

    mIsLittleEndian = AXP_LITTLE_ENDIAN;
    Write(mIsLittleEndian);
    mStream->PopFirst(sizeof(AXP::Boolean));
}

CParcel::CParcel(
    IN AXP::MemoryBuffer<PARCEL_BUFFER_DEFAULT_LENGTH> * stream)
{
    mStream = stream;
    mStream->Reset();
    Read(mIsLittleEndian);
}

AXP::ARESULT CParcel::Reset()
{
    mStream->Reset();
    return Read(mIsLittleEndian);
}

AXP::ARESULT CParcel::Reset(
    IN AXP::PCByte buffer,
    IN CONST AXP::Int32 length)
{
    mStream->Reset();
    mStream->Clear();
    if (!mStream->Append(buffer, length))
        return AXP::AE_OUTOFMEMORY;

    return Reset();
}

AXP::PCByte CParcel::GetPayload()
{
    return mStream->GetPayload();
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int8 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Int8), sizeof(AXP::Int8)))
        return AXP::AE_OUTOFMEMORY;

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt8 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::UInt8), sizeof(AXP::UInt8)))
        return AXP::AE_OUTOFMEMORY;

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int16 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Int16), sizeof(AXP::Int16)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
        AXP::UInt16 temp = (AXP::UInt16)value;
        temp = SWAP_16(temp);
        value = (AXP::Int16)temp;
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt16 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::UInt16), sizeof(AXP::UInt16)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
        value = SWAP_16(value);

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int32 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Int32), sizeof(AXP::Int32)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
        AXP::UInt32 temp = (AXP::UInt32)value;
        temp = SWAP_32(temp);
        value = (AXP::Int32)temp;
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt32 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::UInt32), sizeof(AXP::UInt32)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
        value = SWAP_32(value);

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int64 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Int64), sizeof(AXP::Int64)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
        AXP::UInt64 temp = (AXP::UInt64)value;
        temp = SWAP_64(temp);
        value = (AXP::Int64)temp;
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt64 & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::UInt64), sizeof(AXP::UInt64)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian))
        value = SWAP_64(value);

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Float & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Float), sizeof(AXP::Float)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
        AXP::UInt32 temp = (AXP::UInt32)value;
        temp = SWAP_32(temp);
        value = (AXP::Float)temp;
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Double & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::Double), sizeof(AXP::Double)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
        AXP::UInt64 temp = (AXP::UInt64)value;
        temp = SWAP_64(temp);
        value = (AXP::Double)temp;
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::WChar & value)
{
    if (!mStream->PopFirst(
        (AXP::PByte)&value, sizeof(AXP::WChar), sizeof(AXP::WChar)))
        return AXP::AE_OUTOFMEMORY;

    if (!BYTE_ORDER_EQUAL(mIsLittleEndian)) {
#ifdef PLATFORM_WIN32
        AXP::UInt16 temp = (AXP::UInt16)value;
        temp = SWAP_16(temp);
        value = (AXP::WChar)temp;
#elif defined(PLATFORM_IOS) || defined(PLATFORM_LINUX)
        AXP::UInt32 temp = (AXP::UInt32)value;
        temp = SWAP_32(temp);
        value = (AXP::WChar)temp;
#endif // PLATFORM_WIN32
    }

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int8$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Int8 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt8$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::UInt8 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int16$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Int16 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt16$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::UInt16 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int32$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Int32 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt32$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::UInt32 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Int64$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Int64 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::UInt64$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::UInt64 tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Float$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Float tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::Double$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::Double tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::WChar$ & value)
{
    AXP::Boolean hasValue;
    AXP::ARESULT ar = Read(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        AXP::WChar tempValue;
        ar = Read(tempValue);
        if (AXP::AFAILED(ar))
            return ar;

        value.SetValue(tempValue);
    }
    else
        value.SetNull();

    return ar;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::ByteArray ** value)
{
    if (!value)
        return AXP::AE_INVALIDARG;
    
    AXP::Int32 length;
    AXP::ARESULT ar = Read(length);
    if (AXP::AFAILED(ar))
        return ar;
    
    if (length == 0) {
        if (*value)
            (*value)->Release();
        
        *value = NULL;
        
        return AXP::AS_OK;
    }
    
    AXP::PStr buffer = (AXP::PStr)malloc(length);
    if (!buffer)
        return AXP::AE_OUTOFMEMORY;
    
    if (!mStream->PopFirst((AXP::PByte)buffer, length, length)) {
        free(buffer);
        return AXP::AE_OUTOFMEMORY;
    }
    
    AXP::Sp<AXP::ByteArray> array = AXP::ByteArray::Create(length);
    if (array == NULL) {
        free(buffer);
        return AXP::AE_OUTOFMEMORY;
    }
    
    if (AXP::AFAILED(array->Append((AXP::PCByte)buffer, length))) {
        free(buffer);
        return AXP::AE_OUTOFMEMORY;
    }
    
    if (*value)
        (*value)->Release();
    
    *value = array;
    array->AddRef();
    free(buffer);
    
    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Read(
    INOUT AXP::String ** value)
{
    if (!value)
        return AXP::AE_INVALIDARG;

    AXP::Int32 length;
    AXP::ARESULT ar = Read(length);
    if (AXP::AFAILED(ar))
        return ar;

    if (length == 0) {
        if (*value)
            (*value)->Release();

        *value = NULL;

        return AXP::AS_OK;
    }

    AXP::PStr buffer = (AXP::PStr)malloc(length);
    if (!buffer)
        return AXP::AE_OUTOFMEMORY;

    if (!mStream->PopFirst((AXP::PByte)buffer, length, length)) {
        free(buffer);
        return AXP::AE_OUTOFMEMORY;
    }

    AXP::Sp<AXP::String> string = AXP::String::Create(
        (AXP::PCByte)buffer, sizeof(AXP::Char), length, AXP::EncodingType_UTF8);
    free(buffer);
    if (string == NULL)
        return AXP::AE_OUTOFMEMORY;

    if (*value)
        (*value)->Release();

    *value = string;
    string->AddRef();

    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int8 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Int8)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt8 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::UInt8)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int16 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Int16)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt16 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::UInt16)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int32 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Int32)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt32 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::UInt32)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int64 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Int64)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt64 value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::UInt64)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Float value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Float)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Double value)
{
    if (!mStream->Append((AXP::PCByte)&value, sizeof(AXP::Double)))
        return AXP::AE_OUTOFMEMORY;
    else
        return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int8$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt8$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int16$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt16$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int32$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt32$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Int64$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::UInt64$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN CONST AXP::Float$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN AXP::Double$ value)
{
    AXP::Boolean hasValue = value.HasValue();
    AXP::ARESULT ar = Write(hasValue);
    if (AXP::AFAILED(ar))
        return ar;

    if (hasValue) {
        ar = Write(value.GetValue());
        if (AXP::AFAILED(ar))
            return ar;
    }

    return ar;
}

AXP::ARESULT CParcel::Write(
    IN AXP::ByteArray * value)
{
    if (!value)
        return Write(0);
    
    AXP::Int32 length = value->GetUsed();
    AXP::ARESULT ar = Write(length);
    if (AXP::AFAILED(ar))
        return ar;
    
    if (!mStream->Append(value->GetPayload(), length))
        return AXP::AE_OUTOFMEMORY;
    
    return AXP::AS_OK;
}

AXP::ARESULT CParcel::Write(
    IN AXP::PString value)
{
    if (!value)
        return Write(0);

    AXP::Sp<AXP::ByteArray> ba = value->GetBytes();
    if (ba == NULL)
        return AXP::AE_OUTOFMEMORY;

    AXP::Int32 length = ba->GetUsed();
    if (length == 0)
        return Write(0);

    length = length - 1;
    AXP::ARESULT ar = Write(length);
    if (AXP::AFAILED(ar))
        return ar;

    if (!mStream->Append(ba->GetPayload(), length))
        return AXP::AE_OUTOFMEMORY;

    return AXP::AS_OK;
}
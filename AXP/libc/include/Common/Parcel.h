//
//  Parcel.h
//  CommAnalyzerCore
//
//  Created by zhanwenshu on 14-7-31.
//  Copyright (c) 2014年 Liu Alex. All rights reserved.
//

#ifndef __PARCEL_H__
#define __PARCEL_H__

#include "../../../xplatform/include/type.h"
#include "../../../xplatform/include/aresult.h"
#include "../../../xplatform/include/nullable.h"
#include "../../../xplatform/include/memoryBuffer.h"
#include "../../../xplatform/include/astring.h"
#include "../../../xplatform/include/list.h"

#define PARCEL_BUFFER_DEFAULT_LENGTH (1024)

class IParcelable;

class CParcel : public AXP::CObject
{
public:

    CParcel();

    CParcel(
        IN AXP::MemoryBuffer<PARCEL_BUFFER_DEFAULT_LENGTH> * stream);

public:

    AXP::ARESULT STDCALL Reset();

    AXP::ARESULT STDCALL Reset(
        IN AXP::PCByte buffer,
        IN CONST AXP::Int32 length);

    AXP::PCByte STDCALL GetPayload();

    AXP::Int32 STDCALL GetUsed()
    {
        return mStream->GetUsed();
    }

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int8 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt8 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int16 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt16 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int32 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt32 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int64 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt64 & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Float & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Double & value);
    AXP::ARESULT STDCALL Read(
        INOUT AXP::WChar & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int8$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt8$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int16$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt16$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int32$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt32$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Int64$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::UInt64$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Float$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::Double$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::WChar$ & value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::ByteArray ** value);

    AXP::ARESULT STDCALL Read(
        INOUT AXP::String ** value);

    template<class T>
    AXP::ARESULT STDCALL Read(
        INOUT T ** value)
    {
        if (!value)
            return AXP::AE_INVALIDARG;

        AXP::Boolean hasValue;
        AXP::ARESULT ar = Read(hasValue);
        if (AXP::AFAILED(ar))
            return ar;

        if (hasValue) {
            AXP::Sp<T> temp = new T();
            if (temp == NULL)
                return AXP::AE_OUTOFMEMORY;

            AXP::ARESULT ar = temp->ReadFromParcel(this);
            if (AXP::AFAILED(ar))
                return ar;

            if (*value)
                (*value)->Release();

            *value = temp;
            temp->AddRef();
        }
        else {
            if (*value)
                (*value)->Release();

            *value = NULL;
        }

        return ar;
    }

    template<class T>
    AXP::ARESULT STDCALL Read(
        INOUT AXP::List<T> ** value)
    {
        if (!value)
            return AXP::AE_INVALIDARG;

        AXP::Int32 count;
        AXP::ARESULT ar = Read(count);
        if (AXP::AFAILED(ar))
            return ar;

        if (count == 0) {
            if (*value) {
                (*value)->Release();
                *value = NULL;
            }

            return AXP::AS_OK;
        }

        AXP::Sp<AXP::List<T> > list = new AXP::List<T>();
        if (list == NULL)
            return AXP::AE_OUTOFMEMORY;

        for (AXP::Int32 i = 0; i < count; i++) {
            AXP::Sp<T> obj = new T();
            if (obj == NULL)
                return AXP::AE_OUTOFMEMORY;

            ar = obj->ReadFromParcel(this);
            if (AXP::AFAILED(ar))
                return ar;

            if (!list->PushBack(obj))
                return AXP::AE_OUTOFMEMORY;
        }

        if (*value)
            (*value)->Release();

        *value = list;
        list->AddRef();

        return AXP::AS_OK;
    }

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int8 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt8 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int16 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt16 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int32 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt32 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int64 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt64 value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Float value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Double value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int8$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt8$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int16$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt16$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int32$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt32$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Int64$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::UInt64$ value);

    AXP::ARESULT STDCALL Write(
        IN CONST AXP::Float$ value);

    AXP::ARESULT STDCALL Write(
        IN AXP::Double$ value);
    
    AXP::ARESULT STDCALL Write(
        IN AXP::ByteArray * value);

    AXP::ARESULT STDCALL Write(
        IN AXP::PString value);

    template<class T>
    AXP::ARESULT STDCALL Write(
        IN T * value)
    {
        AXP::Boolean hasValue = TRUE;
        if (!value) {
            hasValue = FALSE;
            return Write(hasValue);
        }

        AXP::ARESULT ar = Write(hasValue);
        if (AXP::AFAILED(ar))
            return ar;

        return value->WriteToParcel(this);
    }

    template<class T>
    AXP::ARESULT STDCALL Write(
        IN AXP::List<T> * value)
    {
        if (!value)
            return Write(0);

        AXP::ARESULT ar = Write(value->GetCount());
        if (AXP::AFAILED(ar))
            return ar;

        Foreach(T, obj, value) {
            ar = obj->WriteToParcel(this);
            if (AXP::AFAILED(ar))
                return ar;
        }

        return AXP::AS_OK;
    }

private:

    AXP::Sp<AXP::MemoryBuffer<PARCEL_BUFFER_DEFAULT_LENGTH> > mStream;
    AXP::Boolean mIsLittleEndian;
};

class IParcelable : public AXP::CObject
{
public:

    VIRTUAL AXP::ARESULT ReadFromParcel(
        IN CParcel * parcel) = 0;

    VIRTUAL AXP::ARESULT WriteToParcel(
        IN CParcel * parcel) = 0;
};

#endif // __PARCEL_H__

//
//  Parcel.h
//  CommAnalyzerCore
//
//  Created by zhanwenshu on 14-7-31.
//  Copyright (c) 2014年 Liu Alex. All rights reserved.
//

#ifndef __PARCEL_H__
#define __PARCEL_H__

#include "type.h"
#include "aresult.h"
#include "memoryStream.h"
#include "astring.h"

#define PARCEL_BUFFER_DEFAULT_LENGTH (1024)

namespace AXP {
    class CParcel : public CObject
    {
    public:

        CParcel();

        CParcel(
            IN CONST Sp<MemoryStream<PARCEL_BUFFER_DEFAULT_LENGTH> > & stream);

    public:

        ARESULT STDCALL Reset();

        ARESULT STDCALL Reset(
            IN PCByte buffer,
            IN CONST Int64 length);

        Int64 STDCALL GetPosition()
        {
            if (mStream == NULL)
                return -1;

            return mStream->GetPosition();
        }

        Void STDCALL Seek(Int64 position)
        {
            if (mStream == NULL)
                return;

            mStream->SetPosition(position);
        }

        PCByte STDCALL GetPayload();

        Int64 STDCALL GetLength()
        {
            if (mStream == NULL)
                return -1;

            return mStream->GetLength();
        }

        ARESULT STDCALL Read(
            INOUT Int8 & value);

        ARESULT STDCALL Read(
            INOUT UInt8 & value);

        ARESULT STDCALL Read(
            INOUT Int16 & value);

        ARESULT STDCALL Read(
            INOUT UInt16 & value);

        ARESULT STDCALL Read(
            INOUT Int32 & value);

        ARESULT STDCALL Read(
            INOUT UInt32 & value);

        ARESULT STDCALL Read(
            INOUT Int64 & value);

        ARESULT STDCALL Read(
            INOUT UInt64 & value);

        ARESULT STDCALL Read(
            INOUT Float & value);

        ARESULT STDCALL Read(
            INOUT Double & value);

        ARESULT STDCALL Read(
            INOUT Sp<ByteArray> & value);

        ARESULT STDCALL Read(
            INOUT Sp<List<ByteArray> > & value);

        ARESULT STDCALL Read(
            INOUT Sp<String> & value);

        ARESULT STDCALL Read(
            INOUT Sp<List<String> > & value);

        ARESULT STDCALL Write(
            IN CONST Int8 value);

        ARESULT STDCALL Write(
            IN CONST UInt8 value);

        ARESULT STDCALL Write(
            IN CONST Int16 value);

        ARESULT STDCALL Write(
            IN CONST UInt16 value);

        ARESULT STDCALL Write(
            IN CONST Int32 value);

        ARESULT STDCALL Write(
            IN CONST UInt32 value);

        ARESULT STDCALL Write(
            IN CONST Int64 value);

        ARESULT STDCALL Write(
            IN CONST UInt64 value);

        ARESULT STDCALL Write(
            IN CONST Float value);

        ARESULT STDCALL Write(
            IN CONST Double value);

        ARESULT STDCALL Write(
            IN CONST Sp<ByteArray> & value);

        ARESULT STDCALL Write(
            IN CONST Sp<List<ByteArray> > & value);

        ARESULT STDCALL Write(
            IN CONST Sp<String> & value);

        ARESULT STDCALL Write(
            IN CONST Sp<List<String> > & value);

    private:

        Sp<MemoryStream<PARCEL_BUFFER_DEFAULT_LENGTH> > mStream;
        Boolean mIsLittleEndian;
    };
} // namespace AXP

#endif // __PARCEL_H__

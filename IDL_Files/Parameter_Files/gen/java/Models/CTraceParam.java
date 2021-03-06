﻿
package Models;

import java.math.BigInteger;
import AXP.CParcel;
import AXP.AResult;

public class CTraceParam extends CRadioMeasParam
{
    public Integer mGid;
    public Integer mIndex;
    public Integer mPacketSize;
    public Integer mTtl;
    public BigInteger mDelay;
    public Integer mStatisticsTtl;
    public BigInteger mStatisticsDelay;
    public Integer mSuccessCount;
    public Integer mFailCount;
    public Integer mCount;
    public String mAddress;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTraceParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mGid)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPacketSize)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTtl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mStatisticsTtl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mStatisticsDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mAddress)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            if (AResult.AFAILED(super.ReadFromParcel(parcel)))
                return AResult.AE_FAIL;

            mGid = parcel.ReadUInt16$();
            mIndex = parcel.ReadUInt16$();
            mPacketSize = parcel.ReadUInt16$();
            mTtl = parcel.ReadUInt16$();
            mDelay = parcel.ReadUInt64$();
            mStatisticsTtl = parcel.ReadUInt16$();
            mStatisticsDelay = parcel.ReadUInt64$();
            mSuccessCount = parcel.ReadUInt16$();
            mFailCount = parcel.ReadUInt16$();
            mCount = parcel.ReadUInt16$();
            mAddress = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTraceParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGid = info.mGid;
        mIndex = info.mIndex;
        mPacketSize = info.mPacketSize;
        mTtl = info.mTtl;
        mDelay = info.mDelay;
        mStatisticsTtl = info.mStatisticsTtl;
        mStatisticsDelay = info.mStatisticsDelay;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;
        mAddress = info.mAddress;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGid = null;
        mIndex = null;
        mPacketSize = null;
        mTtl = null;
        mDelay = null;
        mStatisticsTtl = null;
        mStatisticsDelay = null;
        mSuccessCount = null;
        mFailCount = null;
        mCount = null;
        mAddress = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mGid == null) {
            json = String.format("%s\"mGid\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mGid\":\"%s\",", json, mGid);
            if (json == null)
                return null;
        }

        if (mIndex == null) {
            json = String.format("%s\"mIndex\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
            if (json == null)
                return null;
        }

        if (mPacketSize == null) {
            json = String.format("%s\"mPacketSize\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPacketSize\":\"%s\",", json, mPacketSize);
            if (json == null)
                return null;
        }

        if (mTtl == null) {
            json = String.format("%s\"mTtl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mTtl\":\"%s\",", json, mTtl);
            if (json == null)
                return null;
        }

        if (mDelay == null) {
            json = String.format("%s\"mDelay\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mDelay\":\"%s\",", json, mDelay);
            if (json == null)
                return null;
        }

        if (mStatisticsTtl == null) {
            json = String.format("%s\"mStatisticsTtl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mStatisticsTtl\":\"%s\",", json, mStatisticsTtl);
            if (json == null)
                return null;
        }

        if (mStatisticsDelay == null) {
            json = String.format("%s\"mStatisticsDelay\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mStatisticsDelay\":\"%s\",", json, mStatisticsDelay);
            if (json == null)
                return null;
        }

        if (mSuccessCount == null) {
            json = String.format("%s\"mSuccessCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
            if (json == null)
                return null;
        }

        if (mFailCount == null) {
            json = String.format("%s\"mFailCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFailCount\":\"%s\",", json, mFailCount);
            if (json == null)
                return null;
        }

        if (mCount == null) {
            json = String.format("%s\"mCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCount\":\"%s\",", json, mCount);
            if (json == null)
                return null;
        }

        if (mAddress == null) {
            json = String.format("%s\"mAddress\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mAddress\":\"%s\"", json, mAddress);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CTraceParam";
    }
}


package TestWorkModels;

import AXP.CParcel;
import AXP.AResult;

public class CTraceRouteTestRecord extends CTestRecord
{
    public int mGid;
    public int mIndex;
    public int mPacketSize;
    public String mAddress;
    public int mTtl;
    public long mDelay;
    public int mStatisticsTtl;
    public long mStatisticsDelay;
    public int mSuccessCount;
    public int mFailCount;
    public int mCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CTraceRouteTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mGid)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPacketSize)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mAddress)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTtl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mStatisticsTtl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mStatisticsDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mCount)))
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

            mGid = parcel.ReadInt32();
            mIndex = parcel.ReadInt32();
            mPacketSize = parcel.ReadInt32();
            mAddress = parcel.ReadString();
            mTtl = parcel.ReadInt32();
            mDelay = parcel.ReadInt64();
            mStatisticsTtl = parcel.ReadInt32();
            mStatisticsDelay = parcel.ReadInt64();
            mSuccessCount = parcel.ReadInt32();
            mFailCount = parcel.ReadInt32();
            mCount = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTraceRouteTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGid = info.mGid;
        mIndex = info.mIndex;
        mPacketSize = info.mPacketSize;
        mAddress = info.mAddress;
        mTtl = info.mTtl;
        mDelay = info.mDelay;
        mStatisticsTtl = info.mStatisticsTtl;
        mStatisticsDelay = info.mStatisticsDelay;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGid = 0;
        mIndex = 0;
        mPacketSize = 0;
        mAddress = null;
        mTtl = 0;
        mDelay = 0;
        mStatisticsTtl = 0;
        mStatisticsDelay = 0;
        mSuccessCount = 0;
        mFailCount = 0;
        mCount = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mGid\":\"%s\",", json, mGid);
        if (json == null)
            return null;

        json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
        if (json == null)
            return null;

        json = String.format("%s\"mPacketSize\":\"%s\",", json, mPacketSize);
        if (json == null)
            return null;

        if (mAddress == null) {
            json = String.format("%s\"mAddress\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mAddress\":\"%s\",", json, mAddress);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTtl\":\"%s\",", json, mTtl);
        if (json == null)
            return null;

        json = String.format("%s\"mDelay\":\"%s\",", json, mDelay);
        if (json == null)
            return null;

        json = String.format("%s\"mStatisticsTtl\":\"%s\",", json, mStatisticsTtl);
        if (json == null)
            return null;

        json = String.format("%s\"mStatisticsDelay\":\"%s\",", json, mStatisticsDelay);
        if (json == null)
            return null;

        json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
        if (json == null)
            return null;

        json = String.format("%s\"mFailCount\":\"%s\",", json, mFailCount);
        if (json == null)
            return null;

        json = String.format("%s\"mCount\":\"%s\"", json, mCount);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CTraceRouteTestRecord";
    }
}


package TestWorkModels;

import AXP.CParcel;
import AXP.AResult;

public class CPingTestRecord extends CTestRecord
{
    public int mIndex;
    public int mPacketSize;
    public int mTtl;
    public long mDelay;
    public int mSuccessCount;
    public int mFailCount;
    public int mCount;
    public String mAddress;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CPingTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPacketSize)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTtl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mCount)))
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

            mIndex = parcel.ReadInt32();
            mPacketSize = parcel.ReadInt32();
            mTtl = parcel.ReadInt32();
            mDelay = parcel.ReadInt64();
            mSuccessCount = parcel.ReadInt32();
            mFailCount = parcel.ReadInt32();
            mCount = parcel.ReadInt32();
            mAddress = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CPingTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIndex = info.mIndex;
        mPacketSize = info.mPacketSize;
        mTtl = info.mTtl;
        mDelay = info.mDelay;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;
        mAddress = info.mAddress;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIndex = 0;
        mPacketSize = 0;
        mTtl = 0;
        mDelay = 0;
        mSuccessCount = 0;
        mFailCount = 0;
        mCount = 0;
        mAddress = null;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
        if (json == null)
            return null;

        json = String.format("%s\"mPacketSize\":\"%s\",", json, mPacketSize);
        if (json == null)
            return null;

        json = String.format("%s\"mTtl\":\"%s\",", json, mTtl);
        if (json == null)
            return null;

        json = String.format("%s\"mDelay\":\"%s\",", json, mDelay);
        if (json == null)
            return null;

        json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
        if (json == null)
            return null;

        json = String.format("%s\"mFailCount\":\"%s\",", json, mFailCount);
        if (json == null)
            return null;

        json = String.format("%s\"mCount\":\"%s\",", json, mCount);
        if (json == null)
            return null;

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
        return "TestWorkModels.CPingTestRecord";
    }
}


package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CFtpHttpGroupInfo implements IParcelable
{
    public int mGid;
    public String mUrl;
    public String mFileName;
    public long mLength;
    public long mCount;
    public long mElapsedTime;
    public long mRemainingTime;
    public double mSpeedAvg;
    public int mStatus;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CFtpHttpGroupInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mGid)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFileName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mLength)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mElapsedTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mRemainingTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble(mSpeedAvg)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mStatus)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mGid = parcel.ReadInt32();
            mUrl = parcel.ReadString();
            mFileName = parcel.ReadString();
            mLength = parcel.ReadInt64();
            mCount = parcel.ReadInt64();
            mElapsedTime = parcel.ReadInt64();
            mRemainingTime = parcel.ReadInt64();
            mSpeedAvg = parcel.ReadDouble();
            mStatus = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CFtpHttpGroupInfo info)
    {
        if (info == null)
            return false;

        mGid = info.mGid;
        mUrl = info.mUrl;
        mFileName = info.mFileName;
        mLength = info.mLength;
        mCount = info.mCount;
        mElapsedTime = info.mElapsedTime;
        mRemainingTime = info.mRemainingTime;
        mSpeedAvg = info.mSpeedAvg;
        mStatus = info.mStatus;

        return true;
    }

    public void SetNull()
    {
        mGid = 0;
        mUrl = null;
        mFileName = null;
        mLength = 0;
        mCount = 0;
        mElapsedTime = 0;
        mRemainingTime = 0;
        mSpeedAvg = 0;
        mStatus = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mGid\":\"%s\",", json, mGid);
        if (json == null)
            return null;

        if (mUrl == null) {
            json = String.format("%s\"mUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUrl\":\"%s\",", json, mUrl);
            if (json == null)
                return null;
        }

        if (mFileName == null) {
            json = String.format("%s\"mFileName\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFileName\":\"%s\",", json, mFileName);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mLength\":\"%s\",", json, mLength);
        if (json == null)
            return null;

        json = String.format("%s\"mCount\":\"%s\",", json, mCount);
        if (json == null)
            return null;

        json = String.format("%s\"mElapsedTime\":\"%s\",", json, mElapsedTime);
        if (json == null)
            return null;

        json = String.format("%s\"mRemainingTime\":\"%s\",", json, mRemainingTime);
        if (json == null)
            return null;

        json = String.format("%s\"mSpeedAvg\":\"%s\",", json, mSpeedAvg);
        if (json == null)
            return null;

        json = String.format("%s\"mStatus\":\"%s\"", json, mStatus);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CFtpHttpGroupInfo";
    }
}

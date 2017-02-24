
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CPingConfig implements IParcelable
{
    public int mTestCount;
    public String mIPAddress;
    public int mPackageSize;
    public int mIntervalTime;
    public int mTimeOut;
    public int mTTL;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CPingConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mIPAddress)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPackageSize)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTTL)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTestCount = parcel.ReadInt32();
            mIPAddress = parcel.ReadString();
            mPackageSize = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mTTL = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CPingConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mIPAddress = info.mIPAddress;
        mPackageSize = info.mPackageSize;
        mIntervalTime = info.mIntervalTime;
        mTimeOut = info.mTimeOut;
        mTTL = info.mTTL;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mIPAddress = null;
        mPackageSize = 0;
        mIntervalTime = 0;
        mTimeOut = 0;
        mTTL = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mIPAddress == null) {
            json = String.format("%s\"mIPAddress\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mIPAddress\":\"%s\",", json, mIPAddress);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mPackageSize\":\"%s\",", json, mPackageSize);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mTTL\":\"%s\",", json, mTTL);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CPingConfig";
    }
}

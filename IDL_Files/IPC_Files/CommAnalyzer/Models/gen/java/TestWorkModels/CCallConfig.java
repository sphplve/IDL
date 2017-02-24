
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CCallConfig implements IParcelable
{
    public boolean mIsCalling;
    public int mTestCount;
    public String mPhoneNumber;
    public long mCallingTime;
    public long mIntervalTime;
    public long mConnectedTime;
    public long mCalledTimeout;
    public boolean mIsConnectedAlways;
    public boolean mIsMos;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CCallConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsCalling)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPhoneNumber)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mCallingTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mConnectedTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mCalledTimeout)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsConnectedAlways)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsMos)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mIsCalling = parcel.ReadBoolean();
            mTestCount = parcel.ReadInt32();
            mPhoneNumber = parcel.ReadString();
            mCallingTime = parcel.ReadInt64();
            mIntervalTime = parcel.ReadInt64();
            mConnectedTime = parcel.ReadInt64();
            mCalledTimeout = parcel.ReadInt64();
            mIsConnectedAlways = parcel.ReadBoolean();
            mIsMos = parcel.ReadBoolean();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CCallConfig info)
    {
        if (info == null)
            return false;

        mIsCalling = info.mIsCalling;
        mTestCount = info.mTestCount;
        mPhoneNumber = info.mPhoneNumber;
        mCallingTime = info.mCallingTime;
        mIntervalTime = info.mIntervalTime;
        mConnectedTime = info.mConnectedTime;
        mCalledTimeout = info.mCalledTimeout;
        mIsConnectedAlways = info.mIsConnectedAlways;
        mIsMos = info.mIsMos;

        return true;
    }

    public void SetNull()
    {
        mIsCalling = false;
        mTestCount = 0;
        mPhoneNumber = null;
        mCallingTime = 0;
        mIntervalTime = 0;
        mConnectedTime = 0;
        mCalledTimeout = 0;
        mIsConnectedAlways = false;
        mIsMos = false;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mIsCalling\":\"%s\",", json, mIsCalling);
        if (json == null)
            return null;

        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mPhoneNumber == null) {
            json = String.format("%s\"mPhoneNumber\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPhoneNumber\":\"%s\",", json, mPhoneNumber);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mCallingTime\":\"%s\",", json, mCallingTime);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mConnectedTime\":\"%s\",", json, mConnectedTime);
        if (json == null)
            return null;

        json = String.format("%s\"mCalledTimeout\":\"%s\",", json, mCalledTimeout);
        if (json == null)
            return null;

        json = String.format("%s\"mIsConnectedAlways\":\"%s\",", json, mIsConnectedAlways);
        if (json == null)
            return null;

        json = String.format("%s\"mIsMos\":\"%s\"", json, mIsMos);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CCallConfig";
    }
}

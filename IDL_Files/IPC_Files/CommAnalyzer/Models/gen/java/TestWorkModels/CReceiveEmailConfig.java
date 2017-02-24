
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CReceiveEmailConfig implements IParcelable
{
    public int mTestCount;
    public String mPop3Addr;
    public String mMailAddr;
    public String mPassword;
    public int mPop3Port;
    public int mServerType;
    public int mTimeOut;
    public int mIntervalTime;
    public int mPppType;
    public int mEncryMode;
    public int mLowSpeedTimeout;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CReceiveEmailConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPop3Addr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mMailAddr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPassword)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPop3Port)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mServerType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mEncryMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLowSpeedTimeout)))
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
            mPop3Addr = parcel.ReadString();
            mMailAddr = parcel.ReadString();
            mPassword = parcel.ReadString();
            mPop3Port = parcel.ReadInt32();
            mServerType = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mEncryMode = parcel.ReadInt32();
            mLowSpeedTimeout = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CReceiveEmailConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mPop3Addr = info.mPop3Addr;
        mMailAddr = info.mMailAddr;
        mPassword = info.mPassword;
        mPop3Port = info.mPop3Port;
        mServerType = info.mServerType;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mPppType = info.mPppType;
        mEncryMode = info.mEncryMode;
        mLowSpeedTimeout = info.mLowSpeedTimeout;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mPop3Addr = null;
        mMailAddr = null;
        mPassword = null;
        mPop3Port = 0;
        mServerType = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
        mPppType = 0;
        mEncryMode = 0;
        mLowSpeedTimeout = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mPop3Addr == null) {
            json = String.format("%s\"mPop3Addr\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPop3Addr\":\"%s\",", json, mPop3Addr);
            if (json == null)
                return null;
        }

        if (mMailAddr == null) {
            json = String.format("%s\"mMailAddr\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMailAddr\":\"%s\",", json, mMailAddr);
            if (json == null)
                return null;
        }

        if (mPassword == null) {
            json = String.format("%s\"mPassword\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPassword\":\"%s\",", json, mPassword);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mPop3Port\":\"%s\",", json, mPop3Port);
        if (json == null)
            return null;

        json = String.format("%s\"mServerType\":\"%s\",", json, mServerType);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\",", json, mPppType);
        if (json == null)
            return null;

        json = String.format("%s\"mEncryMode\":\"%s\",", json, mEncryMode);
        if (json == null)
            return null;

        json = String.format("%s\"mLowSpeedTimeout\":\"%s\"", json, mLowSpeedTimeout);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CReceiveEmailConfig";
    }
}

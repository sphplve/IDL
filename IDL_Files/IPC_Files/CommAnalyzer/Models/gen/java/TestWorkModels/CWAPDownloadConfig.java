
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CWAPDownloadConfig implements IParcelable
{
    public int mTestCount;
    public String mUrl;
    public int mTimeOut;
    public int mIntervalTime;
    public int mWAPProtocol;
    public boolean mIsUseGateway;
    public String mProxy;
    public int mPort;
    public int mPppType;
    public int mThreadCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CWAPDownloadConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mWAPProtocol)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsUseGateway)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mProxy)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPort)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mThreadCount)))
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
            mUrl = parcel.ReadString();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mWAPProtocol = parcel.ReadInt32();
            mIsUseGateway = parcel.ReadBoolean();
            mProxy = parcel.ReadString();
            mPort = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mThreadCount = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CWAPDownloadConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mUrl = info.mUrl;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mWAPProtocol = info.mWAPProtocol;
        mIsUseGateway = info.mIsUseGateway;
        mProxy = info.mProxy;
        mPort = info.mPort;
        mPppType = info.mPppType;
        mThreadCount = info.mThreadCount;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mUrl = null;
        mTimeOut = 0;
        mIntervalTime = 0;
        mWAPProtocol = 0;
        mIsUseGateway = false;
        mProxy = null;
        mPort = 0;
        mPppType = 0;
        mThreadCount = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
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

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mWAPProtocol\":\"%s\",", json, mWAPProtocol);
        if (json == null)
            return null;

        json = String.format("%s\"mIsUseGateway\":\"%s\",", json, mIsUseGateway);
        if (json == null)
            return null;

        if (mProxy == null) {
            json = String.format("%s\"mProxy\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mProxy\":\"%s\",", json, mProxy);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mPort\":\"%s\",", json, mPort);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\",", json, mPppType);
        if (json == null)
            return null;

        json = String.format("%s\"mThreadCount\":\"%s\"", json, mThreadCount);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CWAPDownloadConfig";
    }
}

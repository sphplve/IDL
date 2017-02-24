
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CWAPPageConfig implements IParcelable
{
    public int mTestCount;
    public int mTestMode;
    public String mPageUrl;
    public int mTimeOut;
    public int mWAPProtocol;
    public int mIntervalTime;
    public boolean mIsLoadImage;
    public boolean mIsCleanCookie;
    public boolean mIsUseGateway;
    public String mProxy;
    public int mPort;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CWAPPageConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPageUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mWAPProtocol)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsLoadImage)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsCleanCookie)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsUseGateway)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mProxy)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPort)))
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
            mTestMode = parcel.ReadInt32();
            mPageUrl = parcel.ReadString();
            mTimeOut = parcel.ReadInt32();
            mWAPProtocol = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mIsLoadImage = parcel.ReadBoolean();
            mIsCleanCookie = parcel.ReadBoolean();
            mIsUseGateway = parcel.ReadBoolean();
            mProxy = parcel.ReadString();
            mPort = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CWAPPageConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mTestMode = info.mTestMode;
        mPageUrl = info.mPageUrl;
        mTimeOut = info.mTimeOut;
        mWAPProtocol = info.mWAPProtocol;
        mIntervalTime = info.mIntervalTime;
        mIsLoadImage = info.mIsLoadImage;
        mIsCleanCookie = info.mIsCleanCookie;
        mIsUseGateway = info.mIsUseGateway;
        mProxy = info.mProxy;
        mPort = info.mPort;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mTestMode = 0;
        mPageUrl = null;
        mTimeOut = 0;
        mWAPProtocol = 0;
        mIntervalTime = 0;
        mIsLoadImage = false;
        mIsCleanCookie = false;
        mIsUseGateway = false;
        mProxy = null;
        mPort = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        json = String.format("%s\"mTestMode\":\"%s\",", json, mTestMode);
        if (json == null)
            return null;

        if (mPageUrl == null) {
            json = String.format("%s\"mPageUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPageUrl\":\"%s\",", json, mPageUrl);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mWAPProtocol\":\"%s\",", json, mWAPProtocol);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mIsLoadImage\":\"%s\",", json, mIsLoadImage);
        if (json == null)
            return null;

        json = String.format("%s\"mIsCleanCookie\":\"%s\",", json, mIsCleanCookie);
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

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CWAPPageConfig";
    }
}


package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CHttpPageConfig implements IParcelable
{
    public int mTestCount;
    public String mPageUrl;
    public int mTimeOut;
    public int mIntervalTime;
    public int mPppType;
    public int mTestMode;
    public int mLowSpeedTimeOut;
    public boolean mIsLoadImage;
    public boolean mIsCleanCache;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CHttpPageConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPageUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLowSpeedTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsLoadImage)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsCleanCache)))
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
            mPageUrl = parcel.ReadString();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mTestMode = parcel.ReadInt32();
            mLowSpeedTimeOut = parcel.ReadInt32();
            mIsLoadImage = parcel.ReadBoolean();
            mIsCleanCache = parcel.ReadBoolean();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CHttpPageConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mPageUrl = info.mPageUrl;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mPppType = info.mPppType;
        mTestMode = info.mTestMode;
        mLowSpeedTimeOut = info.mLowSpeedTimeOut;
        mIsLoadImage = info.mIsLoadImage;
        mIsCleanCache = info.mIsCleanCache;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mPageUrl = null;
        mTimeOut = 0;
        mIntervalTime = 0;
        mPppType = 0;
        mTestMode = 0;
        mLowSpeedTimeOut = 0;
        mIsLoadImage = false;
        mIsCleanCache = false;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
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

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\",", json, mPppType);
        if (json == null)
            return null;

        json = String.format("%s\"mTestMode\":\"%s\",", json, mTestMode);
        if (json == null)
            return null;

        json = String.format("%s\"mLowSpeedTimeOut\":\"%s\",", json, mLowSpeedTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIsLoadImage\":\"%s\",", json, mIsLoadImage);
        if (json == null)
            return null;

        json = String.format("%s\"mIsCleanCache\":\"%s\"", json, mIsCleanCache);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CHttpPageConfig";
    }
}

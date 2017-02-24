
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CHttpDownloadConfig implements IParcelable
{
    public int mTestCount;
    public String mDownloadUrl;
    public int mTimeOut;
    public int mIntervalTime;
    public int mThreadCount;
    public int mDownloadMode;
    public int mLowSpeedTimeOut;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CHttpDownloadConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mDownloadUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mThreadCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mDownloadMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLowSpeedTimeOut)))
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
            mDownloadUrl = parcel.ReadString();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mThreadCount = parcel.ReadInt32();
            mDownloadMode = parcel.ReadInt32();
            mLowSpeedTimeOut = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CHttpDownloadConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mDownloadUrl = info.mDownloadUrl;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mThreadCount = info.mThreadCount;
        mDownloadMode = info.mDownloadMode;
        mLowSpeedTimeOut = info.mLowSpeedTimeOut;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mDownloadUrl = null;
        mTimeOut = 0;
        mIntervalTime = 0;
        mThreadCount = 0;
        mDownloadMode = 0;
        mLowSpeedTimeOut = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mDownloadUrl == null) {
            json = String.format("%s\"mDownloadUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mDownloadUrl\":\"%s\",", json, mDownloadUrl);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mThreadCount\":\"%s\",", json, mThreadCount);
        if (json == null)
            return null;

        json = String.format("%s\"mDownloadMode\":\"%s\",", json, mDownloadMode);
        if (json == null)
            return null;

        json = String.format("%s\"mLowSpeedTimeOut\":\"%s\",", json, mLowSpeedTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CHttpDownloadConfig";
    }
}


package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CVideoStreamingConfig implements IParcelable
{
    public int mTestCount;
    public String mVideoUrl;
    public int mPlayTime;
    public int mTimeOut;
    public int mIntervalTime;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CVideoStreamingConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mVideoUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPlayTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
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
            mVideoUrl = parcel.ReadString();
            mPlayTime = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CVideoStreamingConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mVideoUrl = info.mVideoUrl;
        mPlayTime = info.mPlayTime;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mVideoUrl = null;
        mPlayTime = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mVideoUrl == null) {
            json = String.format("%s\"mVideoUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mVideoUrl\":\"%s\",", json, mVideoUrl);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mPlayTime\":\"%s\",", json, mPlayTime);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CVideoStreamingConfig";
    }
}

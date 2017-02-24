
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CHttpUploadConfig implements IParcelable
{
    public int mTestCount;
    public String mUploadUrl;
    public String mFilePath;
    public int mFileLength;
    public int mUploadTime;
    public int mIntervalTime;
    public int mLowSpeedTimeOut;
    public int mUploadMode;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CHttpUploadConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mUploadUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFilePath)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mFileLength)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mUploadTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLowSpeedTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mUploadMode)))
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
            mUploadUrl = parcel.ReadString();
            mFilePath = parcel.ReadString();
            mFileLength = parcel.ReadInt32();
            mUploadTime = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mLowSpeedTimeOut = parcel.ReadInt32();
            mUploadMode = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CHttpUploadConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mUploadUrl = info.mUploadUrl;
        mFilePath = info.mFilePath;
        mFileLength = info.mFileLength;
        mUploadTime = info.mUploadTime;
        mIntervalTime = info.mIntervalTime;
        mLowSpeedTimeOut = info.mLowSpeedTimeOut;
        mUploadMode = info.mUploadMode;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mUploadUrl = null;
        mFilePath = null;
        mFileLength = 0;
        mUploadTime = 0;
        mIntervalTime = 0;
        mLowSpeedTimeOut = 0;
        mUploadMode = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mUploadUrl == null) {
            json = String.format("%s\"mUploadUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUploadUrl\":\"%s\",", json, mUploadUrl);
            if (json == null)
                return null;
        }

        if (mFilePath == null) {
            json = String.format("%s\"mFilePath\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFilePath\":\"%s\",", json, mFilePath);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mFileLength\":\"%s\",", json, mFileLength);
        if (json == null)
            return null;

        json = String.format("%s\"mUploadTime\":\"%s\",", json, mUploadTime);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mLowSpeedTimeOut\":\"%s\",", json, mLowSpeedTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mUploadMode\":\"%s\",", json, mUploadMode);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CHttpUploadConfig";
    }
}

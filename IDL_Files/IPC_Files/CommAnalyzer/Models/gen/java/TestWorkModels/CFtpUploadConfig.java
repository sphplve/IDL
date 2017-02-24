
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CFtpUploadConfig implements IParcelable
{
    public int mUploadMode;
    public String mFtpIp;
    public String mFtpUser;
    public String mFtpPwd;
    public String mRemotePath;
    public String mFilePath;
    public int mTestCount;
    public int mFileLength;
    public int mUploadTime;
    public int mTimeOut;
    public int mIntervalTime;
    public int mThreadCount;
    public int mPppType;
    public int mWorkMode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CFtpUploadConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mUploadMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpIp)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpUser)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpPwd)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRemotePath)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFilePath)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mFileLength)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mUploadTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mThreadCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mWorkMode)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mUploadMode = parcel.ReadInt32();
            mFtpIp = parcel.ReadString();
            mFtpUser = parcel.ReadString();
            mFtpPwd = parcel.ReadString();
            mRemotePath = parcel.ReadString();
            mFilePath = parcel.ReadString();
            mTestCount = parcel.ReadInt32();
            mFileLength = parcel.ReadInt32();
            mUploadTime = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mThreadCount = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mWorkMode = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CFtpUploadConfig info)
    {
        if (info == null)
            return false;

        mUploadMode = info.mUploadMode;
        mFtpIp = info.mFtpIp;
        mFtpUser = info.mFtpUser;
        mFtpPwd = info.mFtpPwd;
        mRemotePath = info.mRemotePath;
        mFilePath = info.mFilePath;
        mTestCount = info.mTestCount;
        mFileLength = info.mFileLength;
        mUploadTime = info.mUploadTime;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mThreadCount = info.mThreadCount;
        mPppType = info.mPppType;
        mWorkMode = info.mWorkMode;

        return true;
    }

    public void SetNull()
    {
        mUploadMode = 0;
        mFtpIp = null;
        mFtpUser = null;
        mFtpPwd = null;
        mRemotePath = null;
        mFilePath = null;
        mTestCount = 0;
        mFileLength = 0;
        mUploadTime = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
        mThreadCount = 0;
        mPppType = 0;
        mWorkMode = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mUploadMode\":\"%s\",", json, mUploadMode);
        if (json == null)
            return null;

        if (mFtpIp == null) {
            json = String.format("%s\"mFtpIp\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFtpIp\":\"%s\",", json, mFtpIp);
            if (json == null)
                return null;
        }

        if (mFtpUser == null) {
            json = String.format("%s\"mFtpUser\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFtpUser\":\"%s\",", json, mFtpUser);
            if (json == null)
                return null;
        }

        if (mFtpPwd == null) {
            json = String.format("%s\"mFtpPwd\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFtpPwd\":\"%s\",", json, mFtpPwd);
            if (json == null)
                return null;
        }

        if (mRemotePath == null) {
            json = String.format("%s\"mRemotePath\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRemotePath\":\"%s\",", json, mRemotePath);
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

        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        json = String.format("%s\"mFileLength\":\"%s\",", json, mFileLength);
        if (json == null)
            return null;

        json = String.format("%s\"mUploadTime\":\"%s\",", json, mUploadTime);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mThreadCount\":\"%s\",", json, mThreadCount);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\",", json, mPppType);
        if (json == null)
            return null;

        json = String.format("%s\"mWorkMode\":\"%s\"", json, mWorkMode);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CFtpUploadConfig";
    }
}

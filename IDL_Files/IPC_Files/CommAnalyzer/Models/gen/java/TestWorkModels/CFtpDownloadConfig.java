
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CFtpDownloadConfig implements IParcelable
{
    public int mDownloadMode;
    public String mFtpIp;
    public String mFtpUser;
    public String mFtpPwd;
    public String mRemotePath;
    public int mTestCount;
    public int mDownloadTime;
    public int mTimeOut;
    public int mIntervalTime;
    public int mThreadCount;
    public int mPppType;
    public int mWorkMode;
    public int mSaveOption;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CFtpDownloadConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mDownloadMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpIp)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpUser)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFtpPwd)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRemotePath)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mDownloadTime)))
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

        if (AResult.AFAILED(parcel.WriteInt32(mSaveOption)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mDownloadMode = parcel.ReadInt32();
            mFtpIp = parcel.ReadString();
            mFtpUser = parcel.ReadString();
            mFtpPwd = parcel.ReadString();
            mRemotePath = parcel.ReadString();
            mTestCount = parcel.ReadInt32();
            mDownloadTime = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mThreadCount = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mWorkMode = parcel.ReadInt32();
            mSaveOption = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CFtpDownloadConfig info)
    {
        if (info == null)
            return false;

        mDownloadMode = info.mDownloadMode;
        mFtpIp = info.mFtpIp;
        mFtpUser = info.mFtpUser;
        mFtpPwd = info.mFtpPwd;
        mRemotePath = info.mRemotePath;
        mTestCount = info.mTestCount;
        mDownloadTime = info.mDownloadTime;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mThreadCount = info.mThreadCount;
        mPppType = info.mPppType;
        mWorkMode = info.mWorkMode;
        mSaveOption = info.mSaveOption;

        return true;
    }

    public void SetNull()
    {
        mDownloadMode = 0;
        mFtpIp = null;
        mFtpUser = null;
        mFtpPwd = null;
        mRemotePath = null;
        mTestCount = 0;
        mDownloadTime = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
        mThreadCount = 0;
        mPppType = 0;
        mWorkMode = 0;
        mSaveOption = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mDownloadMode\":\"%s\",", json, mDownloadMode);
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

        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        json = String.format("%s\"mDownloadTime\":\"%s\",", json, mDownloadTime);
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

        json = String.format("%s\"mWorkMode\":\"%s\",", json, mWorkMode);
        if (json == null)
            return null;

        json = String.format("%s\"mSaveOption\":\"%s\"", json, mSaveOption);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CFtpDownloadConfig";
    }
}

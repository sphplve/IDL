
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CSendEmailConfig implements IParcelable
{
    public int mTestCount;
    public String mSmtpAddr;
    public String mMailAddr;
    public String mPassword;
    public String mReceiveMailAddr;
    public String mMailSubject;
    public String mMailBody;
    public int mSmtpPort;
    public int mEncryMode;
    public int mTimeOut;
    public int mIntervalTime;
    public int mLowSpeedTimeout;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CSendEmailConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mSmtpAddr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mMailAddr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPassword)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mReceiveMailAddr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mMailSubject)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mMailBody)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mSmtpPort)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mEncryMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLowSpeedTimeout)))
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
            mSmtpAddr = parcel.ReadString();
            mMailAddr = parcel.ReadString();
            mPassword = parcel.ReadString();
            mReceiveMailAddr = parcel.ReadString();
            mMailSubject = parcel.ReadString();
            mMailBody = parcel.ReadString();
            mSmtpPort = parcel.ReadInt32();
            mEncryMode = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mLowSpeedTimeout = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CSendEmailConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mSmtpAddr = info.mSmtpAddr;
        mMailAddr = info.mMailAddr;
        mPassword = info.mPassword;
        mReceiveMailAddr = info.mReceiveMailAddr;
        mMailSubject = info.mMailSubject;
        mMailBody = info.mMailBody;
        mSmtpPort = info.mSmtpPort;
        mEncryMode = info.mEncryMode;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;
        mLowSpeedTimeout = info.mLowSpeedTimeout;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mSmtpAddr = null;
        mMailAddr = null;
        mPassword = null;
        mReceiveMailAddr = null;
        mMailSubject = null;
        mMailBody = null;
        mSmtpPort = 0;
        mEncryMode = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
        mLowSpeedTimeout = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mSmtpAddr == null) {
            json = String.format("%s\"mSmtpAddr\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSmtpAddr\":\"%s\",", json, mSmtpAddr);
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

        if (mReceiveMailAddr == null) {
            json = String.format("%s\"mReceiveMailAddr\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mReceiveMailAddr\":\"%s\",", json, mReceiveMailAddr);
            if (json == null)
                return null;
        }

        if (mMailSubject == null) {
            json = String.format("%s\"mMailSubject\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMailSubject\":\"%s\",", json, mMailSubject);
            if (json == null)
                return null;
        }

        if (mMailBody == null) {
            json = String.format("%s\"mMailBody\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMailBody\":\"%s\",", json, mMailBody);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mSmtpPort\":\"%s\",", json, mSmtpPort);
        if (json == null)
            return null;

        json = String.format("%s\"mEncryMode\":\"%s\",", json, mEncryMode);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mLowSpeedTimeout\":\"%s\",", json, mLowSpeedTimeout);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CSendEmailConfig";
    }
}

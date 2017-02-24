
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CSmsSendConfig implements IParcelable
{
    public int mSendCount;
    public String mCenterNumber;
    public String mReceiveNumber;
    public String mContent;
    public int mIntervalTime;
    public int mTimeOut;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CSmsSendConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mSendCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mCenterNumber)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mReceiveNumber)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mContent)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mSendCount = parcel.ReadInt32();
            mCenterNumber = parcel.ReadString();
            mReceiveNumber = parcel.ReadString();
            mContent = parcel.ReadString();
            mIntervalTime = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CSmsSendConfig info)
    {
        if (info == null)
            return false;

        mSendCount = info.mSendCount;
        mCenterNumber = info.mCenterNumber;
        mReceiveNumber = info.mReceiveNumber;
        mContent = info.mContent;
        mIntervalTime = info.mIntervalTime;
        mTimeOut = info.mTimeOut;

        return true;
    }

    public void SetNull()
    {
        mSendCount = 0;
        mCenterNumber = null;
        mReceiveNumber = null;
        mContent = null;
        mIntervalTime = 0;
        mTimeOut = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mSendCount\":\"%s\",", json, mSendCount);
        if (json == null)
            return null;

        if (mCenterNumber == null) {
            json = String.format("%s\"mCenterNumber\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCenterNumber\":\"%s\",", json, mCenterNumber);
            if (json == null)
                return null;
        }

        if (mReceiveNumber == null) {
            json = String.format("%s\"mReceiveNumber\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mReceiveNumber\":\"%s\",", json, mReceiveNumber);
            if (json == null)
                return null;
        }

        if (mContent == null) {
            json = String.format("%s\"mContent\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mContent\":\"%s\",", json, mContent);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\"", json, mTimeOut);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CSmsSendConfig";
    }
}

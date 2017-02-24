
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CSmsReceiveConfig implements IParcelable
{
    public int mReceiveCount;
    public int mTimeOut;
    public int mIntervalTime;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CSmsReceiveConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mReceiveCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mReceiveCount = parcel.ReadInt32();
            mTimeOut = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CSmsReceiveConfig info)
    {
        if (info == null)
            return false;

        mReceiveCount = info.mReceiveCount;
        mTimeOut = info.mTimeOut;
        mIntervalTime = info.mIntervalTime;

        return true;
    }

    public void SetNull()
    {
        mReceiveCount = 0;
        mTimeOut = 0;
        mIntervalTime = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mReceiveCount\":\"%s\",", json, mReceiveCount);
        if (json == null)
            return null;

        json = String.format("%s\"mTimeOut\":\"%s\",", json, mTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\"", json, mIntervalTime);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CSmsReceiveConfig";
    }
}

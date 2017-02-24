
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CFtpParam extends CRadioMeasParam
{
    public Double mSpeedAvg;
    // 1 up 2 down
    public Integer mMode;
    public Integer mUsers;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CFtpParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSpeedAvg)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUsers)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            if (AResult.AFAILED(super.ReadFromParcel(parcel)))
                return AResult.AE_FAIL;

            mSpeedAvg = parcel.ReadDouble$();
            mMode = parcel.ReadUInt16$();
            mUsers = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CFtpParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSpeedAvg = info.mSpeedAvg;
        mMode = info.mMode;
        mUsers = info.mUsers;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSpeedAvg = null;
        mMode = null;
        mUsers = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mSpeedAvg == null) {
            json = String.format("%s\"mSpeedAvg\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSpeedAvg\":\"%s\",", json, mSpeedAvg);
            if (json == null)
                return null;
        }

        if (mMode == null) {
            json = String.format("%s\"mMode\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMode\":\"%s\",", json, mMode);
            if (json == null)
                return null;
        }

        if (mUsers == null) {
            json = String.format("%s\"mUsers\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUsers\":\"%s\"", json, mUsers);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CFtpParam";
    }
}

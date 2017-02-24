
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECMPathloss extends CRadioMeasParam
{
    public Double mCMPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECMPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mCMPathloss)))
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

            mCMPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECMPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCMPathloss = info.mCMPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCMPathloss = null;
    }

    public String ToString()
    {
        if (mCMPathloss == null)
            return "";
        else
            return String.format("%s", mCMPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTECMPathloss";
    }
}

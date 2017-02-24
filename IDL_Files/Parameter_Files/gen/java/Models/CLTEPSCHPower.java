
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPSCHPower extends CRadioMeasParam
{
    public Double mPSCHPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPSCHPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPSCHPower)))
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

            mPSCHPower = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPSCHPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPSCHPower = info.mPSCHPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPSCHPower = null;
    }

    public String ToString()
    {
        if (mPSCHPower == null)
            return "";
        else
            return String.format("%s", mPSCHPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPSCHPower";
    }
}

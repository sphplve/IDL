
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESSCHPower extends CRadioMeasParam
{
    public Double mSSCHPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESSCHPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSSCHPower)))
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

            mSSCHPower = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESSCHPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSSCHPower = info.mSSCHPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSSCHPower = null;
    }

    public String ToString()
    {
        if (mSSCHPower == null)
            return "";
        else
            return String.format("%s", mSSCHPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTESSCHPower";
    }
}

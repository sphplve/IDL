
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_A_DPCH_C_I extends CRadioMeasParam
{
    public Double mHS_A_DPCH_C_I;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_A_DPCH_C_I")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_A_DPCH_C_I)))
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

            mHS_A_DPCH_C_I = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_A_DPCH_C_I info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_A_DPCH_C_I = info.mHS_A_DPCH_C_I;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_A_DPCH_C_I = null;
    }

    public String ToString()
    {
        if (mHS_A_DPCH_C_I == null)
            return "";
        else
            return String.format("%s", mHS_A_DPCH_C_I);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_A_DPCH_C_I";
    }
}

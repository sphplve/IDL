
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_OneTime_RTX_Ratio extends CRadioMeasParam
{
    public Double mHS_OneTime_RTX_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_OneTime_RTX_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_OneTime_RTX_Ratio)))
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

            mHS_OneTime_RTX_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_OneTime_RTX_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_OneTime_RTX_Ratio = info.mHS_OneTime_RTX_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_OneTime_RTX_Ratio = null;
    }

    public String ToString()
    {
        if (mHS_OneTime_RTX_Ratio == null)
            return "";
        else
            return String.format("%s", mHS_OneTime_RTX_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_OneTime_RTX_Ratio";
    }
}

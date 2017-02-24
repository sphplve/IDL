
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_DSCH_Error_Ratio extends CRadioMeasParam
{
    public Double mHS_DSCH_Error_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_DSCH_Error_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_DSCH_Error_Ratio)))
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

            mHS_DSCH_Error_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_DSCH_Error_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_DSCH_Error_Ratio = info.mHS_DSCH_Error_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_DSCH_Error_Ratio = null;
    }

    public String ToString()
    {
        if (mHS_DSCH_Error_Ratio == null)
            return "";
        else
            return String.format("%s", mHS_DSCH_Error_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_DSCH_Error_Ratio";
    }
}

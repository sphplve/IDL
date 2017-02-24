
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDS16QAM_Ratio extends CRadioMeasParam
{
    public Double m16QAM_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDS16QAM_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(m16QAM_Ratio)))
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

            m16QAM_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDS16QAM_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        m16QAM_Ratio = info.m16QAM_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        m16QAM_Ratio = null;
    }

    public String ToString()
    {
        if (m16QAM_Ratio == null)
            return "";
        else
            return String.format("%s", m16QAM_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CTDS16QAM_Ratio";
    }
}

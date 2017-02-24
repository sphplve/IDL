
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_PDSCH_TotalBLER extends CRadioMeasParam
{
    public Double mHS_PDSCH_TotalBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_PDSCH_TotalBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_PDSCH_TotalBLER)))
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

            mHS_PDSCH_TotalBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_PDSCH_TotalBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_PDSCH_TotalBLER = info.mHS_PDSCH_TotalBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_PDSCH_TotalBLER = null;
    }

    public String ToString()
    {
        if (mHS_PDSCH_TotalBLER == null)
            return "";
        else
            return String.format("%s", mHS_PDSCH_TotalBLER);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_PDSCH_TotalBLER";
    }
}

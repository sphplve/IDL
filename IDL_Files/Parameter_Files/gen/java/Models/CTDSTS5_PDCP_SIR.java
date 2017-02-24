
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS5_PDCP_SIR extends CRadioMeasParam
{
    public Double mTS5_PDCP_SIR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS5_PDCP_SIR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS5_PDCP_SIR)))
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

            mTS5_PDCP_SIR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS5_PDCP_SIR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS5_PDCP_SIR = info.mTS5_PDCP_SIR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS5_PDCP_SIR = null;
    }

    public String ToString()
    {
        if (mTS5_PDCP_SIR == null)
            return "";
        else
            return String.format("%s", mTS5_PDCP_SIR);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS5_PDCP_SIR";
    }
}

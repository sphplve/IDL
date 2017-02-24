
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS6_PDCP_SIR extends CRadioMeasParam
{
    public Double mTS6_PDCP_SIR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS6_PDCP_SIR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS6_PDCP_SIR)))
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

            mTS6_PDCP_SIR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS6_PDCP_SIR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS6_PDCP_SIR = info.mTS6_PDCP_SIR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS6_PDCP_SIR = null;
    }

    public String ToString()
    {
        if (mTS6_PDCP_SIR == null)
            return "";
        else
            return String.format("%s", mTS6_PDCP_SIR);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS6_PDCP_SIR";
    }
}

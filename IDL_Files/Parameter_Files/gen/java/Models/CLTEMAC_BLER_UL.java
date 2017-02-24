
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMAC_BLER_UL extends CRadioMeasParam
{
    public Double mMAC_BLER_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMAC_BLER_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mMAC_BLER_UL)))
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

            mMAC_BLER_UL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMAC_BLER_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMAC_BLER_UL = info.mMAC_BLER_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMAC_BLER_UL = null;
    }

    public String ToString()
    {
        if (mMAC_BLER_UL == null)
            return "";
        else
            return String.format("%s", mMAC_BLER_UL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMAC_BLER_UL";
    }
}

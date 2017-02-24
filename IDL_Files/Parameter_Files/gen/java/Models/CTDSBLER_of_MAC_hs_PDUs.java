
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSBLER_of_MAC_hs_PDUs extends CRadioMeasParam
{
    public Double mBLER_of_MAC_hs_PDUs;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSBLER_of_MAC_hs_PDUs")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mBLER_of_MAC_hs_PDUs)))
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

            mBLER_of_MAC_hs_PDUs = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSBLER_of_MAC_hs_PDUs info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBLER_of_MAC_hs_PDUs = info.mBLER_of_MAC_hs_PDUs;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBLER_of_MAC_hs_PDUs = null;
    }

    public String ToString()
    {
        if (mBLER_of_MAC_hs_PDUs == null)
            return "";
        else
            return String.format("%s", mBLER_of_MAC_hs_PDUs);
    }

    public String GetTypeName()
    {
        return "Models.CTDSBLER_of_MAC_hs_PDUs";
    }
}

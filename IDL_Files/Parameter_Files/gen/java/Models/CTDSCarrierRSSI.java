
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCarrierRSSI extends CRadioMeasParam
{
    public Double mCarrierRSSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCarrierRSSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mCarrierRSSI)))
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

            mCarrierRSSI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCarrierRSSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCarrierRSSI = info.mCarrierRSSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCarrierRSSI = null;
    }

    public String ToString()
    {
        if (mCarrierRSSI == null)
            return "";
        else
            return String.format("%s", mCarrierRSSI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCarrierRSSI";
    }
}

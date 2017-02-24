
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSNo_MAC_hs_PDU_received extends CRadioMeasParam
{
    public Long mNo_MAC_hs_PDU_received;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSNo_MAC_hs_PDU_received")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mNo_MAC_hs_PDU_received)))
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

            mNo_MAC_hs_PDU_received = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSNo_MAC_hs_PDU_received info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNo_MAC_hs_PDU_received = info.mNo_MAC_hs_PDU_received;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNo_MAC_hs_PDU_received = null;
    }

    public String ToString()
    {
        if (mNo_MAC_hs_PDU_received == null)
            return "";
        else
            return String.format("%s", mNo_MAC_hs_PDU_received);
    }

    public String GetTypeName()
    {
        return "Models.CTDSNo_MAC_hs_PDU_received";
    }
}

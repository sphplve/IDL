
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_PDSCP_CRC_Total extends CRadioMeasParam
{
    public Long mHS_PDSCP_CRC_Total;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_PDSCP_CRC_Total")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mHS_PDSCP_CRC_Total)))
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

            mHS_PDSCP_CRC_Total = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_PDSCP_CRC_Total info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_PDSCP_CRC_Total = info.mHS_PDSCP_CRC_Total;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_PDSCP_CRC_Total = null;
    }

    public String ToString()
    {
        if (mHS_PDSCP_CRC_Total == null)
            return "";
        else
            return String.format("%s", mHS_PDSCP_CRC_Total);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_PDSCP_CRC_Total";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_PDSCH_Error_Blocks extends CRadioMeasParam
{
    public Long mHS_PDSCH_Error_Blocks;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_PDSCH_Error_Blocks")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mHS_PDSCH_Error_Blocks)))
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

            mHS_PDSCH_Error_Blocks = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_PDSCH_Error_Blocks info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_PDSCH_Error_Blocks = info.mHS_PDSCH_Error_Blocks;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_PDSCH_Error_Blocks = null;
    }

    public String ToString()
    {
        if (mHS_PDSCH_Error_Blocks == null)
            return "";
        else
            return String.format("%s", mHS_PDSCH_Error_Blocks);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_PDSCH_Error_Blocks";
    }
}

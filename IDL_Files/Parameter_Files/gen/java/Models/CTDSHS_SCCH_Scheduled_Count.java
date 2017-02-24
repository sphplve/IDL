
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_SCCH_Scheduled_Count extends CRadioMeasParam
{
    public Long mHS_SCCH_Scheduled_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_SCCH_Scheduled_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mHS_SCCH_Scheduled_Count)))
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

            mHS_SCCH_Scheduled_Count = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_SCCH_Scheduled_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_SCCH_Scheduled_Count = info.mHS_SCCH_Scheduled_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_SCCH_Scheduled_Count = null;
    }

    public String ToString()
    {
        if (mHS_SCCH_Scheduled_Count == null)
            return "";
        else
            return String.format("%s", mHS_SCCH_Scheduled_Count);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_SCCH_Scheduled_Count";
    }
}

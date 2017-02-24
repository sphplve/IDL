
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCH_Scheduled_RB_Count_Slot extends CRadioMeasParam
{
    public Long mPUSCH_Scheduled_RB_Count_Slot;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCH_Scheduled_RB_Count_Slot")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPUSCH_Scheduled_RB_Count_Slot)))
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

            mPUSCH_Scheduled_RB_Count_Slot = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCH_Scheduled_RB_Count_Slot info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCH_Scheduled_RB_Count_Slot = info.mPUSCH_Scheduled_RB_Count_Slot;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCH_Scheduled_RB_Count_Slot = null;
    }

    public String ToString()
    {
        if (mPUSCH_Scheduled_RB_Count_Slot == null)
            return "";
        else
            return String.format("%s", mPUSCH_Scheduled_RB_Count_Slot);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCH_Scheduled_RB_Count_Slot";
    }
}

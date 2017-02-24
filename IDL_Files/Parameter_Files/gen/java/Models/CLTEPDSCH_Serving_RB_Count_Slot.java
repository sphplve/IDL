
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCH_Serving_RB_Count_Slot extends CRadioMeasParam
{
    public Long mPDSCH_Serving_RB_Count_Slot;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCH_Serving_RB_Count_Slot")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_Serving_RB_Count_Slot)))
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

            mPDSCH_Serving_RB_Count_Slot = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCH_Serving_RB_Count_Slot info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_Serving_RB_Count_Slot = info.mPDSCH_Serving_RB_Count_Slot;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_Serving_RB_Count_Slot = null;
    }

    public String ToString()
    {
        if (mPDSCH_Serving_RB_Count_Slot == null)
            return "";
        else
            return String.format("%s", mPDSCH_Serving_RB_Count_Slot);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCH_Serving_RB_Count_Slot";
    }
}

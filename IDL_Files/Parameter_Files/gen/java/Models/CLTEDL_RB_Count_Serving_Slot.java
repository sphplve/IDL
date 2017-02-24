
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_RB_Count_Serving_Slot extends CRadioMeasParam
{
    public Double mDL_RB_Count_Serving_Slot;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_RB_Count_Serving_Slot")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_RB_Count_Serving_Slot)))
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

            mDL_RB_Count_Serving_Slot = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_RB_Count_Serving_Slot info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_RB_Count_Serving_Slot = info.mDL_RB_Count_Serving_Slot;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_RB_Count_Serving_Slot = null;
    }

    public String ToString()
    {
        if (mDL_RB_Count_Serving_Slot == null)
            return "";
        else
            return String.format("%s", mDL_RB_Count_Serving_Slot);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_RB_Count_Serving_Slot";
    }
}

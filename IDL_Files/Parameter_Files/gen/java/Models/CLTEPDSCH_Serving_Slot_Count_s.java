
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCH_Serving_Slot_Count_s extends CRadioMeasParam
{
    public Long mPDSCH_Serving_Slot_Count_s;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCH_Serving_Slot_Count_s")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_Serving_Slot_Count_s)))
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

            mPDSCH_Serving_Slot_Count_s = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCH_Serving_Slot_Count_s info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_Serving_Slot_Count_s = info.mPDSCH_Serving_Slot_Count_s;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_Serving_Slot_Count_s = null;
    }

    public String ToString()
    {
        if (mPDSCH_Serving_Slot_Count_s == null)
            return "";
        else
            return String.format("%s", mPDSCH_Serving_Slot_Count_s);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCH_Serving_Slot_Count_s";
    }
}

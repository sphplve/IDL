
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCH_Scheduled_RB_Count_SubFN extends CRadioMeasParam
{
    public Long mPDSCH_Scheduled_RB_Count_SubFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCH_Scheduled_RB_Count_SubFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_Scheduled_RB_Count_SubFN)))
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

            mPDSCH_Scheduled_RB_Count_SubFN = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCH_Scheduled_RB_Count_SubFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_Scheduled_RB_Count_SubFN = info.mPDSCH_Scheduled_RB_Count_SubFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_Scheduled_RB_Count_SubFN = null;
    }

    public String ToString()
    {
        if (mPDSCH_Scheduled_RB_Count_SubFN == null)
            return "";
        else
            return String.format("%s", mPDSCH_Scheduled_RB_Count_SubFN);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCH_Scheduled_RB_Count_SubFN";
    }
}

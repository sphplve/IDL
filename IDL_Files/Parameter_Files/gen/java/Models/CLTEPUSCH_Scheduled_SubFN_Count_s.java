
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCH_Scheduled_SubFN_Count_s extends CRadioMeasParam
{
    public Long mPUSCH_Scheduled_SubFN_Count_s;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCH_Scheduled_SubFN_Count_s")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPUSCH_Scheduled_SubFN_Count_s)))
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

            mPUSCH_Scheduled_SubFN_Count_s = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCH_Scheduled_SubFN_Count_s info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCH_Scheduled_SubFN_Count_s = info.mPUSCH_Scheduled_SubFN_Count_s;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCH_Scheduled_SubFN_Count_s = null;
    }

    public String ToString()
    {
        if (mPUSCH_Scheduled_SubFN_Count_s == null)
            return "";
        else
            return String.format("%s", mPUSCH_Scheduled_SubFN_Count_s);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCH_Scheduled_SubFN_Count_s";
    }
}

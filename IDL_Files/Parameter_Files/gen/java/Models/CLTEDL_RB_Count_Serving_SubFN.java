
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_RB_Count_Serving_SubFN extends CRadioMeasParam
{
    public Double mDL_RB_Count_Serving_SubFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_RB_Count_Serving_SubFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_RB_Count_Serving_SubFN)))
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

            mDL_RB_Count_Serving_SubFN = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_RB_Count_Serving_SubFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_RB_Count_Serving_SubFN = info.mDL_RB_Count_Serving_SubFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_RB_Count_Serving_SubFN = null;
    }

    public String ToString()
    {
        if (mDL_RB_Count_Serving_SubFN == null)
            return "";
        else
            return String.format("%s", mDL_RB_Count_Serving_SubFN);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_RB_Count_Serving_SubFN";
    }
}

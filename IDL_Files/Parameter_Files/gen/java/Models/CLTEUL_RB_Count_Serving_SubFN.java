
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_RB_Count_Serving_SubFN extends CRadioMeasParam
{
    public Double mUL_RB_Count_Serving_SubFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_RB_Count_Serving_SubFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_RB_Count_Serving_SubFN)))
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

            mUL_RB_Count_Serving_SubFN = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_RB_Count_Serving_SubFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_RB_Count_Serving_SubFN = info.mUL_RB_Count_Serving_SubFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_RB_Count_Serving_SubFN = null;
    }

    public String ToString()
    {
        if (mUL_RB_Count_Serving_SubFN == null)
            return "";
        else
            return String.format("%s", mUL_RB_Count_Serving_SubFN);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_RB_Count_Serving_SubFN";
    }
}

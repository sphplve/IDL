
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_MCS_Code0_Total_Count extends CRadioMeasParam
{
    public Long mDL_MCS_Code0_Total_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_MCS_Code0_Total_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mDL_MCS_Code0_Total_Count)))
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

            mDL_MCS_Code0_Total_Count = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_MCS_Code0_Total_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_MCS_Code0_Total_Count = info.mDL_MCS_Code0_Total_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_MCS_Code0_Total_Count = null;
    }

    public String ToString()
    {
        if (mDL_MCS_Code0_Total_Count == null)
            return "";
        else
            return String.format("%s", mDL_MCS_Code0_Total_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_MCS_Code0_Total_Count";
    }
}

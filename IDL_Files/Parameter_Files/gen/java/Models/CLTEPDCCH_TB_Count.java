
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_TB_Count extends CRadioMeasParam
{
    public Integer mPDCCH_TB_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_TB_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mPDCCH_TB_Count)))
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

            mPDCCH_TB_Count = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_TB_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_TB_Count = info.mPDCCH_TB_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_TB_Count = null;
    }

    public String ToString()
    {
        if (mPDCCH_TB_Count == null)
            return "";
        else
            return String.format("%s", mPDCCH_TB_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_TB_Count";
    }
}

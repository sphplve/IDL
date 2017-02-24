
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_UL_GrantCount extends CRadioMeasParam
{
    public Integer mPDCCH_UL_GrantCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_UL_GrantCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPDCCH_UL_GrantCount)))
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

            mPDCCH_UL_GrantCount = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_UL_GrantCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_UL_GrantCount = info.mPDCCH_UL_GrantCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_UL_GrantCount = null;
    }

    public String ToString()
    {
        if (mPDCCH_UL_GrantCount == null)
            return "";
        else
            return String.format("%s", mPDCCH_UL_GrantCount);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_UL_GrantCount";
    }
}

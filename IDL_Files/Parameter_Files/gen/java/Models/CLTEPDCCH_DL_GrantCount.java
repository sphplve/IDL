
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_DL_GrantCount extends CRadioMeasParam
{
    public Integer mPDCCH_DL_GrantCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_DL_GrantCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPDCCH_DL_GrantCount)))
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

            mPDCCH_DL_GrantCount = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_DL_GrantCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_DL_GrantCount = info.mPDCCH_DL_GrantCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_DL_GrantCount = null;
    }

    public String ToString()
    {
        if (mPDCCH_DL_GrantCount == null)
            return "";
        else
            return String.format("%s", mPDCCH_DL_GrantCount);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_DL_GrantCount";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCCCH_SDCCH_COMB extends CRadioMeasParam
{
    public Short mCCCH_SDCCH_COMB;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCCCH_SDCCH_COMB")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCCCH_SDCCH_COMB)))
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

            mCCCH_SDCCH_COMB = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCCCH_SDCCH_COMB info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCCCH_SDCCH_COMB = info.mCCCH_SDCCH_COMB;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCCCH_SDCCH_COMB = null;
    }

    public String ToString()
    {
        if (mCCCH_SDCCH_COMB == null)
            return "";
        else
            return String.format("%s", mCCCH_SDCCH_COMB);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCCCH_SDCCH_COMB";
    }
}

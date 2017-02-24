
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUCCH_NACK_Count extends CRadioMeasParam
{
    public Integer mPUCCH_NACK_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUCCH_NACK_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPUCCH_NACK_Count)))
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

            mPUCCH_NACK_Count = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUCCH_NACK_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUCCH_NACK_Count = info.mPUCCH_NACK_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUCCH_NACK_Count = null;
    }

    public String ToString()
    {
        if (mPUCCH_NACK_Count == null)
            return "";
        else
            return String.format("%s", mPUCCH_NACK_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUCCH_NACK_Count";
    }
}

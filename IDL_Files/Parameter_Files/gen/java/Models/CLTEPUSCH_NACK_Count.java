
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCH_NACK_Count extends CRadioMeasParam
{
    public Integer mPUSCH_NACK_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCH_NACK_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPUSCH_NACK_Count)))
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

            mPUSCH_NACK_Count = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCH_NACK_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCH_NACK_Count = info.mPUSCH_NACK_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCH_NACK_Count = null;
    }

    public String ToString()
    {
        if (mPUSCH_NACK_Count == null)
            return "";
        else
            return String.format("%s", mPUSCH_NACK_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCH_NACK_Count";
    }
}

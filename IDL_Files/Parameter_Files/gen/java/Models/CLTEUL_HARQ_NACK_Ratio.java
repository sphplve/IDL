
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_HARQ_NACK_Ratio extends CRadioMeasParam
{
    public Double mUL_HARQ_NACK_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_HARQ_NACK_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_HARQ_NACK_Ratio)))
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

            mUL_HARQ_NACK_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_HARQ_NACK_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_HARQ_NACK_Ratio = info.mUL_HARQ_NACK_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_HARQ_NACK_Ratio = null;
    }

    public String ToString()
    {
        if (mUL_HARQ_NACK_Ratio == null)
            return "";
        else
            return String.format("%s", mUL_HARQ_NACK_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_HARQ_NACK_Ratio";
    }
}

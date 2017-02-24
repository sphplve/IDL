
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECode0_DL_HARQ_NACK_Ratio extends CRadioMeasParam
{
    public Double mCode0_DL_HARQ_NACK_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECode0_DL_HARQ_NACK_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mCode0_DL_HARQ_NACK_Ratio)))
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

            mCode0_DL_HARQ_NACK_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECode0_DL_HARQ_NACK_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCode0_DL_HARQ_NACK_Ratio = info.mCode0_DL_HARQ_NACK_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCode0_DL_HARQ_NACK_Ratio = null;
    }

    public String ToString()
    {
        if (mCode0_DL_HARQ_NACK_Ratio == null)
            return "";
        else
            return String.format("%s", mCode0_DL_HARQ_NACK_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CLTECode0_DL_HARQ_NACK_Ratio";
    }
}

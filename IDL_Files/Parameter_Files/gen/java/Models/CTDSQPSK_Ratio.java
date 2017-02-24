
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSQPSK_Ratio extends CRadioMeasParam
{
    public Double mQPSK_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSQPSK_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mQPSK_Ratio)))
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

            mQPSK_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSQPSK_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQPSK_Ratio = info.mQPSK_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQPSK_Ratio = null;
    }

    public String ToString()
    {
        if (mQPSK_Ratio == null)
            return "";
        else
            return String.format("%s", mQPSK_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CTDSQPSK_Ratio";
    }
}

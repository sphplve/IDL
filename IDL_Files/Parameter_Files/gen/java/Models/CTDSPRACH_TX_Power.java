
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_TX_Power extends CRadioMeasParam
{
    public Double mPRACH_TX_Power;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_TX_Power")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPRACH_TX_Power)))
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

            mPRACH_TX_Power = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_TX_Power info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_TX_Power = info.mPRACH_TX_Power;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_TX_Power = null;
    }

    public String ToString()
    {
        if (mPRACH_TX_Power == null)
            return "";
        else
            return String.format("%s", mPRACH_TX_Power);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_TX_Power";
    }
}

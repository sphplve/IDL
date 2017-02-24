
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRetransmission_Counter extends CRadioMeasParam
{
    public String mRetransmission_Counter;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRetransmission_Counter")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRetransmission_Counter)))
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

            mRetransmission_Counter = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRetransmission_Counter info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRetransmission_Counter = info.mRetransmission_Counter;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRetransmission_Counter = null;
    }

    public String ToString()
    {
        if (mRetransmission_Counter == null)
            return String.format("");
        else
            return mRetransmission_Counter;
    }

    public String GetTypeName()
    {
        return "Models.CGSMRetransmission_Counter";
    }
}

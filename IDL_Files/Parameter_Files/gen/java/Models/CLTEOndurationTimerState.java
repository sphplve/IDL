
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEOndurationTimerState extends CRadioMeasParam
{
    public String mOndurationTimerState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEOndurationTimerState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mOndurationTimerState)))
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

            mOndurationTimerState = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEOndurationTimerState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mOndurationTimerState = info.mOndurationTimerState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mOndurationTimerState = null;
    }

    public String ToString()
    {
        if (mOndurationTimerState == null)
            return String.format("");
        else
            return mOndurationTimerState;
    }

    public String GetTypeName()
    {
        return "Models.CLTEOndurationTimerState";
    }
}

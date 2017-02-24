
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEInactivityTimerState extends CRadioMeasParam
{
    public Short mInactivityTimerState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEInactivityTimerState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mInactivityTimerState)))
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

            mInactivityTimerState = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEInactivityTimerState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mInactivityTimerState = info.mInactivityTimerState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mInactivityTimerState = null;
    }

    public String ToString()
    {
        if (mInactivityTimerState == null)
            return "";
        else
            return String.format("%s", mInactivityTimerState);
    }

    public String GetTypeName()
    {
        return "Models.CLTEInactivityTimerState";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDrxInactivityTimer extends CRadioMeasParam
{
    public Integer mDrxInactivityTimer;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDrxInactivityTimer")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDrxInactivityTimer)))
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

            mDrxInactivityTimer = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDrxInactivityTimer info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDrxInactivityTimer = info.mDrxInactivityTimer;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDrxInactivityTimer = null;
    }

    public String ToString()
    {
        if (mDrxInactivityTimer == null)
            return "";
        else
            return String.format("%s", mDrxInactivityTimer);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDrxInactivityTimer";
    }
}

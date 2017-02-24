
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEInactivityTimer extends CRadioMeasParam
{
    public Integer mInactivityTimer;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEInactivityTimer")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mInactivityTimer)))
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

            mInactivityTimer = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEInactivityTimer info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mInactivityTimer = info.mInactivityTimer;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mInactivityTimer = null;
    }

    public String ToString()
    {
        if (mInactivityTimer == null)
            return "";
        else
            return String.format("%s", mInactivityTimer);
    }

    public String GetTypeName()
    {
        return "Models.CLTEInactivityTimer";
    }
}

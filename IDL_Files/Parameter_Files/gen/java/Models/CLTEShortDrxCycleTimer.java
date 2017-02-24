
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEShortDrxCycleTimer extends CRadioMeasParam
{
    public Short mShortDrxCycleTimer;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEShortDrxCycleTimer")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mShortDrxCycleTimer)))
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

            mShortDrxCycleTimer = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEShortDrxCycleTimer info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mShortDrxCycleTimer = info.mShortDrxCycleTimer;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mShortDrxCycleTimer = null;
    }

    public String ToString()
    {
        if (mShortDrxCycleTimer == null)
            return "";
        else
            return String.format("%s", mShortDrxCycleTimer);
    }

    public String GetTypeName()
    {
        return "Models.CLTEShortDrxCycleTimer";
    }
}

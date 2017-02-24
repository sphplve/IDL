
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDrxRetxTimer extends CRadioMeasParam
{
    public Short mDrxRetxTimer;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDrxRetxTimer")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDrxRetxTimer)))
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

            mDrxRetxTimer = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDrxRetxTimer info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDrxRetxTimer = info.mDrxRetxTimer;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDrxRetxTimer = null;
    }

    public String ToString()
    {
        if (mDrxRetxTimer == null)
            return "";
        else
            return String.format("%s", mDrxRetxTimer);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDrxRetxTimer";
    }
}

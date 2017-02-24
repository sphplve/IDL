
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEShortDrxCycle extends CRadioMeasParam
{
    public Integer mShortDrxCycle;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEShortDrxCycle")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mShortDrxCycle)))
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

            mShortDrxCycle = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEShortDrxCycle info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mShortDrxCycle = info.mShortDrxCycle;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mShortDrxCycle = null;
    }

    public String ToString()
    {
        if (mShortDrxCycle == null)
            return "";
        else
            return String.format("%s", mShortDrxCycle);
    }

    public String GetTypeName()
    {
        return "Models.CLTEShortDrxCycle";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTELongDrxCycle extends CRadioMeasParam
{
    public Integer mLongDrxCycle;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTELongDrxCycle")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mLongDrxCycle)))
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

            mLongDrxCycle = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTELongDrxCycle info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mLongDrxCycle = info.mLongDrxCycle;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mLongDrxCycle = null;
    }

    public String ToString()
    {
        if (mLongDrxCycle == null)
            return "";
        else
            return String.format("%s", mLongDrxCycle);
    }

    public String GetTypeName()
    {
        return "Models.CLTELongDrxCycle";
    }
}

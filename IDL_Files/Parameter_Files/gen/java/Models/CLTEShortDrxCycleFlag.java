
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEShortDrxCycleFlag extends CRadioMeasParam
{
    public String mShortDrxCycleFlag;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEShortDrxCycleFlag")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mShortDrxCycleFlag)))
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

            mShortDrxCycleFlag = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEShortDrxCycleFlag info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mShortDrxCycleFlag = info.mShortDrxCycleFlag;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mShortDrxCycleFlag = null;
    }

    public String ToString()
    {
        if (mShortDrxCycleFlag == null)
            return String.format("");
        else
            return mShortDrxCycleFlag;
    }

    public String GetTypeName()
    {
        return "Models.CLTEShortDrxCycleFlag";
    }
}

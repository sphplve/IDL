
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDrxStartedFlag extends CRadioMeasParam
{
    public String mDrxStartedFlag;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDrxStartedFlag")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mDrxStartedFlag)))
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

            mDrxStartedFlag = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDrxStartedFlag info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDrxStartedFlag = info.mDrxStartedFlag;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDrxStartedFlag = null;
    }

    public String ToString()
    {
        if (mDrxStartedFlag == null)
            return String.format("");
        else
            return mDrxStartedFlag;
    }

    public String GetTypeName()
    {
        return "Models.CLTEDrxStartedFlag";
    }
}

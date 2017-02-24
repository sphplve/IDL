
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEWorkMode extends CRadioMeasParam
{
    public String mWorkMode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEWorkMode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mWorkMode)))
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

            mWorkMode = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEWorkMode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWorkMode = info.mWorkMode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWorkMode = null;
    }

    public String ToString()
    {
        if (mWorkMode == null)
            return String.format("");
        else
            return mWorkMode;
    }

    public String GetTypeName()
    {
        return "Models.CLTEWorkMode";
    }
}

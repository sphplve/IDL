
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEEMMState extends CRadioMeasParam
{
    public String mEMMState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEEMMState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mEMMState)))
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

            mEMMState = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEEMMState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEMMState = info.mEMMState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEMMState = null;
    }

    public String ToString()
    {
        if (mEMMState == null)
            return String.format("");
        else
            return mEMMState;
    }

    public String GetTypeName()
    {
        return "Models.CLTEEMMState";
    }
}

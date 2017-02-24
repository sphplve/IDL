
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEEMMSubState extends CRadioMeasParam
{
    public String mEMMSubState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEEMMSubState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mEMMSubState)))
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

            mEMMSubState = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEEMMSubState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEMMSubState = info.mEMMSubState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEMMSubState = null;
    }

    public String ToString()
    {
        if (mEMMSubState == null)
            return String.format("");
        else
            return mEMMSubState;
    }

    public String GetTypeName()
    {
        return "Models.CLTEEMMSubState";
    }
}

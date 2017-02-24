
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTENASState extends CRadioMeasParam
{
    public String mNASState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTENASState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mNASState)))
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

            mNASState = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTENASState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNASState = info.mNASState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNASState = null;
    }

    public String ToString()
    {
        if (mNASState == null)
            return String.format("");
        else
            return mNASState;
    }

    public String GetTypeName()
    {
        return "Models.CLTENASState";
    }
}

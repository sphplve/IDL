
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERRCState extends CRadioMeasParam
{
    public String mRRCState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERRCState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRRCState)))
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

            mRRCState = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERRCState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRRCState = info.mRRCState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRRCState = null;
    }

    public String ToString()
    {
        if (mRRCState == null)
            return String.format("");
        else
            return mRRCState;
    }

    public String GetTypeName()
    {
        return "Models.CLTERRCState";
    }
}

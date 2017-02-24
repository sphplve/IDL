
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEOndurationTimer extends CRadioMeasParam
{
    public Short mOndurationTimer;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEOndurationTimer")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mOndurationTimer)))
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

            mOndurationTimer = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEOndurationTimer info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mOndurationTimer = info.mOndurationTimer;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mOndurationTimer = null;
    }

    public String ToString()
    {
        if (mOndurationTimer == null)
            return "";
        else
            return String.format("%s", mOndurationTimer);
    }

    public String GetTypeName()
    {
        return "Models.CLTEOndurationTimer";
    }
}

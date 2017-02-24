
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCValue extends CRadioMeasParam
{
    public Short mCValue;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCValue")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mCValue)))
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

            mCValue = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCValue info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCValue = info.mCValue;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCValue = null;
    }

    public String ToString()
    {
        if (mCValue == null)
            return "";
        else
            return String.format("%s", mCValue);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCValue";
    }
}

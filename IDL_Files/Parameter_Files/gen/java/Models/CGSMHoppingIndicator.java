
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMHoppingIndicator extends CRadioMeasParam
{
    public Short mHoppingIndicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMHoppingIndicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHoppingIndicator)))
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

            mHoppingIndicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMHoppingIndicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHoppingIndicator = info.mHoppingIndicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHoppingIndicator = null;
    }

    public String ToString()
    {
        if (mHoppingIndicator == null)
            return "";
        else
            return String.format("%s", mHoppingIndicator);
    }

    public String GetTypeName()
    {
        return "Models.CGSMHoppingIndicator";
    }
}

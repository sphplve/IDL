
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMHoppingType extends CRadioMeasParam
{
    public Short mHoppingType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMHoppingType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHoppingType)))
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

            mHoppingType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMHoppingType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHoppingType = info.mHoppingType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHoppingType = null;
    }

    public String ToString()
    {
        if (mHoppingType == null)
            return "";
        else
            return String.format("%s", mHoppingType);
    }

    public String GetTypeName()
    {
        return "Models.CGSMHoppingType";
    }
}

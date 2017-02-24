
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMBCCHLevel extends CRadioMeasParam
{
    public Short mBCCHLevel;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMBCCHLevel")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mBCCHLevel)))
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

            mBCCHLevel = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMBCCHLevel info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBCCHLevel = info.mBCCHLevel;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBCCHLevel = null;
    }

    public String ToString()
    {
        if (mBCCHLevel == null)
            return "";
        else
            return String.format("%s", mBCCHLevel);
    }

    public String GetTypeName()
    {
        return "Models.CGSMBCCHLevel";
    }
}

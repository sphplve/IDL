
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDSCCurrent extends CRadioMeasParam
{
    public Long mDSCCurrent;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDSCCurrent")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mDSCCurrent)))
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

            mDSCCurrent = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDSCCurrent info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDSCCurrent = info.mDSCCurrent;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDSCCurrent = null;
    }

    public String ToString()
    {
        if (mDSCCurrent == null)
            return "";
        else
            return String.format("%s", mDSCCurrent);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDSCCurrent";
    }
}

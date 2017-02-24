
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMAccess_burst_type extends CRadioMeasParam
{
    public String mAccess_burst_type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMAccess_burst_type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mAccess_burst_type)))
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

            mAccess_burst_type = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMAccess_burst_type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAccess_burst_type = info.mAccess_burst_type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAccess_burst_type = null;
    }

    public String ToString()
    {
        if (mAccess_burst_type == null)
            return String.format("");
        else
            return mAccess_burst_type;
    }

    public String GetTypeName()
    {
        return "Models.CGSMAccess_burst_type";
    }
}

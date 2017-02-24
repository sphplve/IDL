
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEAccessClassBar extends CRadioMeasParam
{
    public String mAccessClassBar;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEAccessClassBar")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mAccessClassBar)))
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

            mAccessClassBar = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEAccessClassBar info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAccessClassBar = info.mAccessClassBar;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAccessClassBar = null;
    }

    public String ToString()
    {
        if (mAccessClassBar == null)
            return String.format("");
        else
            return mAccessClassBar;
    }

    public String GetTypeName()
    {
        return "Models.CLTEAccessClassBar";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMChannel_type extends CRadioMeasParam
{
    public String mChannel_type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMChannel_type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mChannel_type)))
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

            mChannel_type = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMChannel_type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mChannel_type = info.mChannel_type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mChannel_type = null;
    }

    public String ToString()
    {
        if (mChannel_type == null)
            return String.format("");
        else
            return mChannel_type;
    }

    public String GetTypeName()
    {
        return "Models.CGSMChannel_type";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMChannel_mode extends CRadioMeasParam
{
    public Short mChannel_mode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMChannel_mode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mChannel_mode)))
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

            mChannel_mode = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMChannel_mode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mChannel_mode = info.mChannel_mode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mChannel_mode = null;
    }

    public String ToString()
    {
        if (mChannel_mode == null)
            return "";
        else
            return String.format("%s", mChannel_mode);
    }

    public String GetTypeName()
    {
        return "Models.CGSMChannel_mode";
    }
}

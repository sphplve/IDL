
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMSubchannel_number extends CRadioMeasParam
{
    public Short mSubchannel_number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMSubchannel_number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSubchannel_number)))
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

            mSubchannel_number = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMSubchannel_number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSubchannel_number = info.mSubchannel_number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSubchannel_number = null;
    }

    public String ToString()
    {
        if (mSubchannel_number == null)
            return "";
        else
            return String.format("%s", mSubchannel_number);
    }

    public String GetTypeName()
    {
        return "Models.CGSMSubchannel_number";
    }
}

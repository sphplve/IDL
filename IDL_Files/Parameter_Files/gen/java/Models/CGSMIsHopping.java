
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMIsHopping extends CRadioMeasParam
{
    public Short mIsHopping;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMIsHopping")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mIsHopping)))
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

            mIsHopping = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMIsHopping info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIsHopping = info.mIsHopping;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIsHopping = null;
    }

    public String ToString()
    {
        if (mIsHopping == null)
            return "";
        else
            return String.format("%s", mIsHopping);
    }

    public String GetTypeName()
    {
        return "Models.CGSMIsHopping";
    }
}

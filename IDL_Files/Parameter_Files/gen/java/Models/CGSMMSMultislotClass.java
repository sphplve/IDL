
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMSMultislotClass extends CRadioMeasParam
{
    public Short mMSMultislotClass;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMSMultislotClass")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMSMultislotClass)))
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

            mMSMultislotClass = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMSMultislotClass info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMSMultislotClass = info.mMSMultislotClass;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMSMultislotClass = null;
    }

    public String ToString()
    {
        if (mMSMultislotClass == null)
            return "";
        else
            return String.format("%s", mMSMultislotClass);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMSMultislotClass";
    }
}

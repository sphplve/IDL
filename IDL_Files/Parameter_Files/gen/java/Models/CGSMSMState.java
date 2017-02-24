
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMSMState extends CRadioMeasParam
{
    public Short mSMState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMSMState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSMState)))
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

            mSMState = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMSMState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSMState = info.mSMState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSMState = null;
    }

    public String ToString()
    {
        if (mSMState == null)
            return "";
        else
            return String.format("%s", mSMState);
    }

    public String GetTypeName()
    {
        return "Models.CGSMSMState";
    }
}

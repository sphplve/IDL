
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMAttachState extends CRadioMeasParam
{
    public Short mAttachState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMAttachState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mAttachState)))
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

            mAttachState = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMAttachState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAttachState = info.mAttachState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAttachState = null;
    }

    public String ToString()
    {
        if (mAttachState == null)
            return "";
        else
            return String.format("%s", mAttachState);
    }

    public String GetTypeName()
    {
        return "Models.CGSMAttachState";
    }
}

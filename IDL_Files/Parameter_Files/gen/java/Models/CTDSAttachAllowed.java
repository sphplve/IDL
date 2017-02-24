
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSAttachAllowed extends CRadioMeasParam
{
    public Short mAttachAllowed;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSAttachAllowed")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mAttachAllowed)))
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

            mAttachAllowed = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSAttachAllowed info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAttachAllowed = info.mAttachAllowed;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAttachAllowed = null;
    }

    public String ToString()
    {
        if (mAttachAllowed == null)
            return "";
        else
            return String.format("%s", mAttachAllowed);
    }

    public String GetTypeName()
    {
        return "Models.CTDSAttachAllowed";
    }
}

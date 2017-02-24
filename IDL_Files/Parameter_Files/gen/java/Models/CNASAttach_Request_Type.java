
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASAttach_Request_Type extends CRadioMeasParam
{
    public Short mAttach_Request_Type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASAttach_Request_Type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mAttach_Request_Type)))
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

            mAttach_Request_Type = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASAttach_Request_Type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAttach_Request_Type = info.mAttach_Request_Type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAttach_Request_Type = null;
    }

    public String ToString()
    {
        if (mAttach_Request_Type == null)
            return "";
        else
            return String.format("%s", mAttach_Request_Type);
    }

    public String GetTypeName()
    {
        return "Models.CNASAttach_Request_Type";
    }
}

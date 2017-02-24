
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPacketDataCapability extends CRadioMeasParam
{
    public Short mPacketDataCapability;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPacketDataCapability")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPacketDataCapability)))
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

            mPacketDataCapability = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPacketDataCapability info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPacketDataCapability = info.mPacketDataCapability;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPacketDataCapability = null;
    }

    public String ToString()
    {
        if (mPacketDataCapability == null)
            return "";
        else
            return String.format("%s", mPacketDataCapability);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPacketDataCapability";
    }
}

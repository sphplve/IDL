
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASWCDMAServiceType extends CRadioMeasParam
{
    public Short mWCDMAServiceType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASWCDMAServiceType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mWCDMAServiceType)))
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

            mWCDMAServiceType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASWCDMAServiceType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWCDMAServiceType = info.mWCDMAServiceType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWCDMAServiceType = null;
    }

    public String ToString()
    {
        if (mWCDMAServiceType == null)
            return "";
        else
            return String.format("%s", mWCDMAServiceType);
    }

    public String GetTypeName()
    {
        return "Models.CNASWCDMAServiceType";
    }
}

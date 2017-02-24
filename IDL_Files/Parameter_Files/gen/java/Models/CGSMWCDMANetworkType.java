
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMWCDMANetworkType extends CRadioMeasParam
{
    public Short mWCDMANetworkType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMWCDMANetworkType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mWCDMANetworkType)))
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

            mWCDMANetworkType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMWCDMANetworkType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWCDMANetworkType = info.mWCDMANetworkType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWCDMANetworkType = null;
    }

    public String ToString()
    {
        if (mWCDMANetworkType == null)
            return "";
        else
            return String.format("%s", mWCDMANetworkType);
    }

    public String GetTypeName()
    {
        return "Models.CGSMWCDMANetworkType";
    }
}

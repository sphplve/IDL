
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMNetworkType extends CRadioMeasParam
{
    public Short mNetworkType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNetworkType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNetworkType)))
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

            mNetworkType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNetworkType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNetworkType = info.mNetworkType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNetworkType = null;
    }

    public String ToString()
    {
        if (mNetworkType == null)
            return "";
        else
            return String.format("%s", mNetworkType);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNetworkType";
    }
}

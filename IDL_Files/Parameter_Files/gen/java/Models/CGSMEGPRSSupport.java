
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMEGPRSSupport extends CRadioMeasParam
{
    public Short mEGPRSSupport;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMEGPRSSupport")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mEGPRSSupport)))
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

            mEGPRSSupport = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMEGPRSSupport info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEGPRSSupport = info.mEGPRSSupport;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEGPRSSupport = null;
    }

    public String ToString()
    {
        if (mEGPRSSupport == null)
            return "";
        else
            return String.format("%s", mEGPRSSupport);
    }

    public String GetTypeName()
    {
        return "Models.CGSMEGPRSSupport";
    }
}

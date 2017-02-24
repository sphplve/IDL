
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPowerRamping extends CRadioMeasParam
{
    public Short mPowerRamping;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPowerRamping")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPowerRamping)))
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

            mPowerRamping = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPowerRamping info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPowerRamping = info.mPowerRamping;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPowerRamping = null;
    }

    public String ToString()
    {
        if (mPowerRamping == null)
            return "";
        else
            return String.format("%s", mPowerRamping);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPowerRamping";
    }
}

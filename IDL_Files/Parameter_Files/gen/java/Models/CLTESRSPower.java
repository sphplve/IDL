
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESRSPower extends CRadioMeasParam
{
    public Byte mSRSPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESRSPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mSRSPower)))
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

            mSRSPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESRSPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSRSPower = info.mSRSPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSRSPower = null;
    }

    public String ToString()
    {
        if (mSRSPower == null)
            return "";
        else
            return String.format("%s", mSRSPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTESRSPower";
    }
}

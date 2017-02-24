
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUCCHTxPower extends CRadioMeasParam
{
    public Byte mPUCCHTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUCCHTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mPUCCHTxPower)))
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

            mPUCCHTxPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUCCHTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUCCHTxPower = info.mPUCCHTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUCCHTxPower = null;
    }

    public String ToString()
    {
        if (mPUCCHTxPower == null)
            return "";
        else
            return String.format("%s", mPUCCHTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUCCHTxPower";
    }
}

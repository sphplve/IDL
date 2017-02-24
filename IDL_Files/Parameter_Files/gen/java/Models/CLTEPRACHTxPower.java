
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPRACHTxPower extends CRadioMeasParam
{
    public Byte mPRACHTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPRACHTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mPRACHTxPower)))
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

            mPRACHTxPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPRACHTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACHTxPower = info.mPRACHTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACHTxPower = null;
    }

    public String ToString()
    {
        if (mPRACHTxPower == null)
            return "";
        else
            return String.format("%s", mPRACHTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPRACHTxPower";
    }
}

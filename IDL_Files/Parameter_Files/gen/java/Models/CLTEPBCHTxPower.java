
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPBCHTxPower extends CRadioMeasParam
{
    public Integer mPBCHTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPBCHTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mPBCHTxPower)))
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

            mPBCHTxPower = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPBCHTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPBCHTxPower = info.mPBCHTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPBCHTxPower = null;
    }

    public String ToString()
    {
        if (mPBCHTxPower == null)
            return "";
        else
            return String.format("%s", mPBCHTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPBCHTxPower";
    }
}

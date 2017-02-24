
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUETxPower extends CRadioMeasParam
{
    public Byte mUETxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUETxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mUETxPower)))
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

            mUETxPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUETxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUETxPower = info.mUETxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUETxPower = null;
    }

    public String ToString()
    {
        if (mUETxPower == null)
            return "";
        else
            return String.format("%s", mUETxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUETxPower";
    }
}

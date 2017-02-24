
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUETxPower extends CRadioMeasParam
{
    public Double mUETxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUETxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUETxPower)))
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

            mUETxPower = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUETxPower info)
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
        return "Models.CTDSUETxPower";
    }
}

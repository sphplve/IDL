
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUpPCHTxPower extends CRadioMeasParam
{
    public Double mUpPCHTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUpPCHTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUpPCHTxPower)))
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

            mUpPCHTxPower = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUpPCHTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUpPCHTxPower = info.mUpPCHTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUpPCHTxPower = null;
    }

    public String ToString()
    {
        if (mUpPCHTxPower == null)
            return "";
        else
            return String.format("%s", mUpPCHTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUpPCHTxPower";
    }
}

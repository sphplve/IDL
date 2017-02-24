
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUEMaxAllowedULTxPower extends CRadioMeasParam
{
    public Long mUEMaxAllowedULTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUEMaxAllowedULTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mUEMaxAllowedULTxPower)))
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

            mUEMaxAllowedULTxPower = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUEMaxAllowedULTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUEMaxAllowedULTxPower = info.mUEMaxAllowedULTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUEMaxAllowedULTxPower = null;
    }

    public String ToString()
    {
        if (mUEMaxAllowedULTxPower == null)
            return "";
        else
            return String.format("%s", mUEMaxAllowedULTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUEMaxAllowedULTxPower";
    }
}

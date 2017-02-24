
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEInitialTxPower extends CRadioMeasParam
{
    public Byte mInitialTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEInitialTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mInitialTxPower)))
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

            mInitialTxPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEInitialTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mInitialTxPower = info.mInitialTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mInitialTxPower = null;
    }

    public String ToString()
    {
        if (mInitialTxPower == null)
            return "";
        else
            return String.format("%s", mInitialTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEInitialTxPower";
    }
}

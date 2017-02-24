
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTxPower extends CRadioMeasParam
{
    public Integer mTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTxPower)))
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

            mTxPower = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTxPower = info.mTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTxPower = null;
    }

    public String ToString()
    {
        if (mTxPower == null)
            return "";
        else
            return String.format("%s", mTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTxPower";
    }
}

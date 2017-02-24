
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMsTxPowerMaxCCH extends CRadioMeasParam
{
    public Short mMsTxPowerMaxCCH;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMsTxPowerMaxCCH")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMsTxPowerMaxCCH)))
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

            mMsTxPowerMaxCCH = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMsTxPowerMaxCCH info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMsTxPowerMaxCCH = info.mMsTxPowerMaxCCH;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMsTxPowerMaxCCH = null;
    }

    public String ToString()
    {
        if (mMsTxPowerMaxCCH == null)
            return "";
        else
            return String.format("%s", mMsTxPowerMaxCCH);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMsTxPowerMaxCCH";
    }
}

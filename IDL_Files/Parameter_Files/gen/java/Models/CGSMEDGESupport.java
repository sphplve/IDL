
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMEDGESupport extends CRadioMeasParam
{
    public Short mEDGESupport;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMEDGESupport")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mEDGESupport)))
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

            mEDGESupport = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMEDGESupport info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEDGESupport = info.mEDGESupport;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEDGESupport = null;
    }

    public String ToString()
    {
        if (mEDGESupport == null)
            return "";
        else
            return String.format("%s", mEDGESupport);
    }

    public String GetTypeName()
    {
        return "Models.CGSMEDGESupport";
    }
}

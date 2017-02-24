
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMAXRET extends CRadioMeasParam
{
    public Short mMAXRET;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMAXRET")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMAXRET)))
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

            mMAXRET = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMAXRET info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMAXRET = info.mMAXRET;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMAXRET = null;
    }

    public String ToString()
    {
        if (mMAXRET == null)
            return "";
        else
            return String.format("%s", mMAXRET);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMAXRET";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSAttach_Indicator extends CRadioMeasParam
{
    public Short mAttach_Indicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSAttach_Indicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mAttach_Indicator)))
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

            mAttach_Indicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSAttach_Indicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAttach_Indicator = info.mAttach_Indicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAttach_Indicator = null;
    }

    public String ToString()
    {
        if (mAttach_Indicator == null)
            return "";
        else
            return String.format("%s", mAttach_Indicator);
    }

    public String GetTypeName()
    {
        return "Models.CTDSAttach_Indicator";
    }
}

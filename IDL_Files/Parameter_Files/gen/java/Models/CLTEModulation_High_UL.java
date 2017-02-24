
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEModulation_High_UL extends CRadioMeasParam
{
    public Short mModulation_High_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEModulation_High_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mModulation_High_UL)))
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

            mModulation_High_UL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEModulation_High_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mModulation_High_UL = info.mModulation_High_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mModulation_High_UL = null;
    }

    public String ToString()
    {
        if (mModulation_High_UL == null)
            return "";
        else
            return String.format("%s", mModulation_High_UL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEModulation_High_UL";
    }
}

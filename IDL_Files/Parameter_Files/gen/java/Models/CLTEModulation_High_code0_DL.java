
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEModulation_High_code0_DL extends CRadioMeasParam
{
    public Short mModulation_High_code0_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEModulation_High_code0_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mModulation_High_code0_DL)))
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

            mModulation_High_code0_DL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEModulation_High_code0_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mModulation_High_code0_DL = info.mModulation_High_code0_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mModulation_High_code0_DL = null;
    }

    public String ToString()
    {
        if (mModulation_High_code0_DL == null)
            return "";
        else
            return String.format("%s", mModulation_High_code0_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEModulation_High_code0_DL";
    }
}

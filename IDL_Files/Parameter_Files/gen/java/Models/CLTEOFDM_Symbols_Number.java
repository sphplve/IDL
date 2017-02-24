
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEOFDM_Symbols_Number extends CRadioMeasParam
{
    public Short mOFDM_Symbols_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEOFDM_Symbols_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mOFDM_Symbols_Number)))
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

            mOFDM_Symbols_Number = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEOFDM_Symbols_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mOFDM_Symbols_Number = info.mOFDM_Symbols_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mOFDM_Symbols_Number = null;
    }

    public String ToString()
    {
        if (mOFDM_Symbols_Number == null)
            return "";
        else
            return String.format("%s", mOFDM_Symbols_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTEOFDM_Symbols_Number";
    }
}

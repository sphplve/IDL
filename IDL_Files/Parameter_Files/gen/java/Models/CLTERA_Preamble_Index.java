
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERA_Preamble_Index extends CRadioMeasParam
{
    public Short mRA_Preamble_Index;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERA_Preamble_Index")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRA_Preamble_Index)))
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

            mRA_Preamble_Index = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERA_Preamble_Index info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRA_Preamble_Index = info.mRA_Preamble_Index;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRA_Preamble_Index = null;
    }

    public String ToString()
    {
        if (mRA_Preamble_Index == null)
            return "";
        else
            return String.format("%s", mRA_Preamble_Index);
    }

    public String GetTypeName()
    {
        return "Models.CLTERA_Preamble_Index";
    }
}

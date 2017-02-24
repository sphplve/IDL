
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSNew_Data_Indicator extends CRadioMeasParam
{
    public Short mNew_Data_Indicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSNew_Data_Indicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNew_Data_Indicator)))
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

            mNew_Data_Indicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSNew_Data_Indicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNew_Data_Indicator = info.mNew_Data_Indicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNew_Data_Indicator = null;
    }

    public String ToString()
    {
        if (mNew_Data_Indicator == null)
            return "";
        else
            return String.format("%s", mNew_Data_Indicator);
    }

    public String GetTypeName()
    {
        return "Models.CTDSNew_Data_Indicator";
    }
}

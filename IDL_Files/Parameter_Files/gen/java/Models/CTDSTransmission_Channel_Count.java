
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTransmission_Channel_Count extends CRadioMeasParam
{
    public Short mTransmission_Channel_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTransmission_Channel_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTransmission_Channel_Count)))
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

            mTransmission_Channel_Count = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTransmission_Channel_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTransmission_Channel_Count = info.mTransmission_Channel_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTransmission_Channel_Count = null;
    }

    public String ToString()
    {
        if (mTransmission_Channel_Count == null)
            return "";
        else
            return String.format("%s", mTransmission_Channel_Count);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTransmission_Channel_Count";
    }
}

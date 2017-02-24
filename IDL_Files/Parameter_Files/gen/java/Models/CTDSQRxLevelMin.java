
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSQRxLevelMin extends CRadioMeasParam
{
    public Byte mQRxLevelMin;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSQRxLevelMin")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mQRxLevelMin)))
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

            mQRxLevelMin = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSQRxLevelMin info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQRxLevelMin = info.mQRxLevelMin;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQRxLevelMin = null;
    }

    public String ToString()
    {
        if (mQRxLevelMin == null)
            return "";
        else
            return String.format("%s", mQRxLevelMin);
    }

    public String GetTypeName()
    {
        return "Models.CTDSQRxLevelMin";
    }
}

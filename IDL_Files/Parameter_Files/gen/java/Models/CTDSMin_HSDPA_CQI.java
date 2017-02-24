
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSMin_HSDPA_CQI extends CRadioMeasParam
{
    public Short mMin_HSDPA_CQI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSMin_HSDPA_CQI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMin_HSDPA_CQI)))
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

            mMin_HSDPA_CQI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSMin_HSDPA_CQI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMin_HSDPA_CQI = info.mMin_HSDPA_CQI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMin_HSDPA_CQI = null;
    }

    public String ToString()
    {
        if (mMin_HSDPA_CQI == null)
            return "";
        else
            return String.format("%s", mMin_HSDPA_CQI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSMin_HSDPA_CQI";
    }
}

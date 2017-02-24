
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCQI_Indicator extends CRadioMeasParam
{
    public Short mCQI_Indicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCQI_Indicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCQI_Indicator)))
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

            mCQI_Indicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCQI_Indicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCQI_Indicator = info.mCQI_Indicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCQI_Indicator = null;
    }

    public String ToString()
    {
        if (mCQI_Indicator == null)
            return "";
        else
            return String.format("%s", mCQI_Indicator);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCQI_Indicator";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHCS_Indicator extends CRadioMeasParam
{
    public Short mHCS_Indicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHCS_Indicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHCS_Indicator)))
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

            mHCS_Indicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHCS_Indicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHCS_Indicator = info.mHCS_Indicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHCS_Indicator = null;
    }

    public String ToString()
    {
        if (mHCS_Indicator == null)
            return "";
        else
            return String.format("%s", mHCS_Indicator);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHCS_Indicator";
    }
}

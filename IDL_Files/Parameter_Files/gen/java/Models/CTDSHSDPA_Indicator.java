
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHSDPA_Indicator extends CRadioMeasParam
{
    public Short mHSDPA_Indicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHSDPA_Indicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHSDPA_Indicator)))
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

            mHSDPA_Indicator = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHSDPA_Indicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHSDPA_Indicator = info.mHSDPA_Indicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHSDPA_Indicator = null;
    }

    public String ToString()
    {
        if (mHSDPA_Indicator == null)
            return "";
        else
            return String.format("%s", mHSDPA_Indicator);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHSDPA_Indicator";
    }
}

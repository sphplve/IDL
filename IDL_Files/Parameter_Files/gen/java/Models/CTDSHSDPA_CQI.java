
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHSDPA_CQI extends CRadioMeasParam
{
    public Short mHSDPA_CQI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHSDPA_CQI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHSDPA_CQI)))
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

            mHSDPA_CQI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHSDPA_CQI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHSDPA_CQI = info.mHSDPA_CQI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHSDPA_CQI = null;
    }

    public String ToString()
    {
        if (mHSDPA_CQI == null)
            return "";
        else
            return String.format("%s", mHSDPA_CQI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHSDPA_CQI";
    }
}

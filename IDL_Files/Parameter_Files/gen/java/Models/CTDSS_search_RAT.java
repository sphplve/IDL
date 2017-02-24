
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSS_search_RAT extends CRadioMeasParam
{
    public Short mS_search_RAT;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSS_search_RAT")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mS_search_RAT)))
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

            mS_search_RAT = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSS_search_RAT info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mS_search_RAT = info.mS_search_RAT;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mS_search_RAT = null;
    }

    public String ToString()
    {
        if (mS_search_RAT == null)
            return "";
        else
            return String.format("%s", mS_search_RAT);
    }

    public String GetTypeName()
    {
        return "Models.CTDSS_search_RAT";
    }
}

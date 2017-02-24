
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_BLER extends CRadioMeasParam
{
    public Double mPDCCH_BLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_BLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDCCH_BLER)))
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

            mPDCCH_BLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_BLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_BLER = info.mPDCCH_BLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_BLER = null;
    }

    public String ToString()
    {
        if (mPDCCH_BLER == null)
            return "";
        else
            return String.format("%s", mPDCCH_BLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_BLER";
    }
}

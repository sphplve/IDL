
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_SCCH_BLER extends CRadioMeasParam
{
    public Double mHS_SCCH_BLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_SCCH_BLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_SCCH_BLER)))
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

            mHS_SCCH_BLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_SCCH_BLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_SCCH_BLER = info.mHS_SCCH_BLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_SCCH_BLER = null;
    }

    public String ToString()
    {
        if (mHS_SCCH_BLER == null)
            return "";
        else
            return String.format("%s", mHS_SCCH_BLER);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_SCCH_BLER";
    }
}

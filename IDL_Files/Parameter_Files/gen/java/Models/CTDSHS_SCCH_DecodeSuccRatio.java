
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_SCCH_DecodeSuccRatio extends CRadioMeasParam
{
    public Double mHS_SCCH_DecodeSuccRatio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_SCCH_DecodeSuccRatio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHS_SCCH_DecodeSuccRatio)))
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

            mHS_SCCH_DecodeSuccRatio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_SCCH_DecodeSuccRatio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_SCCH_DecodeSuccRatio = info.mHS_SCCH_DecodeSuccRatio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_SCCH_DecodeSuccRatio = null;
    }

    public String ToString()
    {
        if (mHS_SCCH_DecodeSuccRatio == null)
            return "";
        else
            return String.format("%s", mHS_SCCH_DecodeSuccRatio);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_SCCH_DecodeSuccRatio";
    }
}

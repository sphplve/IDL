
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHS_SCCH_Uarfn extends CRadioMeasParam
{
    public Integer mHS_SCCH_Uarfn;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHS_SCCH_Uarfn")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mHS_SCCH_Uarfn)))
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

            mHS_SCCH_Uarfn = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHS_SCCH_Uarfn info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHS_SCCH_Uarfn = info.mHS_SCCH_Uarfn;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHS_SCCH_Uarfn = null;
    }

    public String ToString()
    {
        if (mHS_SCCH_Uarfn == null)
            return "";
        else
            return String.format("%s", mHS_SCCH_Uarfn);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHS_SCCH_Uarfn";
    }
}

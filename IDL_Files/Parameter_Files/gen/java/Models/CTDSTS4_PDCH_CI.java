
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS4_PDCH_CI extends CRadioMeasParam
{
    public Double mTS4_PDCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS4_PDCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS4_PDCH_CI)))
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

            mTS4_PDCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS4_PDCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS4_PDCH_CI = info.mTS4_PDCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS4_PDCH_CI = null;
    }

    public String ToString()
    {
        if (mTS4_PDCH_CI == null)
            return "";
        else
            return String.format("%s", mTS4_PDCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS4_PDCH_CI";
    }
}

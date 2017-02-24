
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS2_PDCH_CI extends CRadioMeasParam
{
    public Double mTS2_PDCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS2_PDCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS2_PDCH_CI)))
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

            mTS2_PDCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS2_PDCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS2_PDCH_CI = info.mTS2_PDCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS2_PDCH_CI = null;
    }

    public String ToString()
    {
        if (mTS2_PDCH_CI == null)
            return "";
        else
            return String.format("%s", mTS2_PDCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS2_PDCH_CI";
    }
}

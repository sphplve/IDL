
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUL_PDCP_Thr extends CRadioMeasParam
{
    public Double mUL_PDCP_Thr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUL_PDCP_Thr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_PDCP_Thr)))
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

            mUL_PDCP_Thr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUL_PDCP_Thr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_PDCP_Thr = info.mUL_PDCP_Thr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_PDCP_Thr = null;
    }

    public String ToString()
    {
        if (mUL_PDCP_Thr == null)
            return "";
        else
            return String.format("%s", mUL_PDCP_Thr);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUL_PDCP_Thr";
    }
}

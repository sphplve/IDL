
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDL_PDCP_Thr extends CRadioMeasParam
{
    public Double mDL_PDCP_Thr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDL_PDCP_Thr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_PDCP_Thr)))
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

            mDL_PDCP_Thr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDL_PDCP_Thr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_PDCP_Thr = info.mDL_PDCP_Thr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_PDCP_Thr = null;
    }

    public String ToString()
    {
        if (mDL_PDCP_Thr == null)
            return "";
        else
            return String.format("%s", mDL_PDCP_Thr);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDL_PDCP_Thr";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMGPRS_ReTx_Ratio extends CRadioMeasParam
{
    public Double mGPRS_ReTx_Ratio;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMGPRS_ReTx_Ratio")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mGPRS_ReTx_Ratio)))
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

            mGPRS_ReTx_Ratio = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMGPRS_ReTx_Ratio info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGPRS_ReTx_Ratio = info.mGPRS_ReTx_Ratio;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGPRS_ReTx_Ratio = null;
    }

    public String ToString()
    {
        if (mGPRS_ReTx_Ratio == null)
            return "";
        else
            return String.format("%s", mGPRS_ReTx_Ratio);
    }

    public String GetTypeName()
    {
        return "Models.CGSMGPRS_ReTx_Ratio";
    }
}

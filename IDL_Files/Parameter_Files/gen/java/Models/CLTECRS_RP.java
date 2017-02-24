
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECRS_RP extends CRadioMeasParam
{
    public Double mCRS_RP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECRS_RP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mCRS_RP)))
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

            mCRS_RP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECRS_RP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCRS_RP = info.mCRS_RP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCRS_RP = null;
    }

    public String ToString()
    {
        if (mCRS_RP == null)
            return "";
        else
            return String.format("%s", mCRS_RP);
    }

    public String GetTypeName()
    {
        return "Models.CLTECRS_RP";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMBCCH_CI extends CRadioMeasParam
{
    public Double mBCCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMBCCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mBCCH_CI)))
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

            mBCCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMBCCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBCCH_CI = info.mBCCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBCCH_CI = null;
    }

    public String ToString()
    {
        if (mBCCH_CI == null)
            return "";
        else
            return String.format("%s", mBCCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMBCCH_CI";
    }
}

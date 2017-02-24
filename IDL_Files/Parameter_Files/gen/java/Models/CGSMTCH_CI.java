
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTCH_CI extends CRadioMeasParam
{
    public Double mTCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTCH_CI)))
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

            mTCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTCH_CI = info.mTCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTCH_CI = null;
    }

    public String ToString()
    {
        if (mTCH_CI == null)
            return "";
        else
            return String.format("%s", mTCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTCH_CI";
    }
}

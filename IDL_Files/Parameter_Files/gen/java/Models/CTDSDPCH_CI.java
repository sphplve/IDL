
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDPCH_CI extends CRadioMeasParam
{
    public Double mDPCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDPCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDPCH_CI)))
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

            mDPCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDPCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDPCH_CI = info.mDPCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDPCH_CI = null;
    }

    public String ToString()
    {
        if (mDPCH_CI == null)
            return "";
        else
            return String.format("%s", mDPCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDPCH_CI";
    }
}

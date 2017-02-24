
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDPCH_RSCP extends CRadioMeasParam
{
    public Double mDPCH_RSCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDPCH_RSCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDPCH_RSCP)))
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

            mDPCH_RSCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDPCH_RSCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDPCH_RSCP = info.mDPCH_RSCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDPCH_RSCP = null;
    }

    public String ToString()
    {
        if (mDPCH_RSCP == null)
            return "";
        else
            return String.format("%s", mDPCH_RSCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDPCH_RSCP";
    }
}

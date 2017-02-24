
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDPCH_ISCP extends CRadioMeasParam
{
    public Double mDPCH_ISCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDPCH_ISCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDPCH_ISCP)))
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

            mDPCH_ISCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDPCH_ISCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDPCH_ISCP = info.mDPCH_ISCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDPCH_ISCP = null;
    }

    public String ToString()
    {
        if (mDPCH_ISCP == null)
            return "";
        else
            return String.format("%s", mDPCH_ISCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDPCH_ISCP";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDPCH_SIR extends CRadioMeasParam
{
    public Double mDPCH_SIR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDPCH_SIR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDPCH_SIR)))
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

            mDPCH_SIR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDPCH_SIR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDPCH_SIR = info.mDPCH_SIR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDPCH_SIR = null;
    }

    public String ToString()
    {
        if (mDPCH_SIR == null)
            return "";
        else
            return String.format("%s", mDPCH_SIR);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDPCH_SIR";
    }
}

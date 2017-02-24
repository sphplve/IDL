
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDPCH_SIR_Target extends CRadioMeasParam
{
    public Double mDPCH_SIR_Target;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDPCH_SIR_Target")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDPCH_SIR_Target)))
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

            mDPCH_SIR_Target = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDPCH_SIR_Target info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDPCH_SIR_Target = info.mDPCH_SIR_Target;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDPCH_SIR_Target = null;
    }

    public String ToString()
    {
        if (mDPCH_SIR_Target == null)
            return "";
        else
            return String.format("%s", mDPCH_SIR_Target);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDPCH_SIR_Target";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPCCPCH_SIR extends CRadioMeasParam
{
    public Double mPCCPCH_SIR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPCCPCH_SIR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPCCPCH_SIR)))
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

            mPCCPCH_SIR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPCCPCH_SIR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCCPCH_SIR = info.mPCCPCH_SIR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCCPCH_SIR = null;
    }

    public String ToString()
    {
        if (mPCCPCH_SIR == null)
            return "";
        else
            return String.format("%s", mPCCPCH_SIR);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPCCPCH_SIR";
    }
}

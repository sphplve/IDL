
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPCCPCH_CI extends CRadioMeasParam
{
    public Double mPCCPCH_CI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPCCPCH_CI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPCCPCH_CI)))
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

            mPCCPCH_CI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPCCPCH_CI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCCPCH_CI = info.mPCCPCH_CI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCCPCH_CI = null;
    }

    public String ToString()
    {
        if (mPCCPCH_CI == null)
            return "";
        else
            return String.format("%s", mPCCPCH_CI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPCCPCH_CI";
    }
}

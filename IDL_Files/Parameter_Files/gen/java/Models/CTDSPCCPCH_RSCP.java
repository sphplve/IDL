
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPCCPCH_RSCP extends CRadioMeasParam
{
    public Double mPCCPCH_RSCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPCCPCH_RSCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPCCPCH_RSCP)))
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

            mPCCPCH_RSCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPCCPCH_RSCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCCPCH_RSCP = info.mPCCPCH_RSCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCCPCH_RSCP = null;
    }

    public String ToString()
    {
        if (mPCCPCH_RSCP == null)
            return "";
        else
            return String.format("%s", mPCCPCH_RSCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPCCPCH_RSCP";
    }
}

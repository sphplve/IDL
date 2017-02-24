
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPCCPCH_ISCP extends CRadioMeasParam
{
    public Double mPCCPCH_ISCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPCCPCH_ISCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPCCPCH_ISCP)))
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

            mPCCPCH_ISCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPCCPCH_ISCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCCPCH_ISCP = info.mPCCPCH_ISCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCCPCH_ISCP = null;
    }

    public String ToString()
    {
        if (mPCCPCH_ISCP == null)
            return "";
        else
            return String.format("%s", mPCCPCH_ISCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPCCPCH_ISCP";
    }
}

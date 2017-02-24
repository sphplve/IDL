
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPCCPCHPathloss extends CRadioMeasParam
{
    public Double mPCCPCHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPCCPCHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPCCPCHPathloss)))
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

            mPCCPCHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPCCPCHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCCPCHPathloss = info.mPCCPCHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCCPCHPathloss = null;
    }

    public String ToString()
    {
        if (mPCCPCHPathloss == null)
            return "";
        else
            return String.format("%s", mPCCPCHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPCCPCHPathloss";
    }
}

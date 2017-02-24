
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUCCHPathloss extends CRadioMeasParam
{
    public Double mPUCCHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUCCHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUCCHPathloss)))
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

            mPUCCHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUCCHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUCCHPathloss = info.mPUCCHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUCCHPathloss = null;
    }

    public String ToString()
    {
        if (mPUCCHPathloss == null)
            return "";
        else
            return String.format("%s", mPUCCHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUCCHPathloss";
    }
}

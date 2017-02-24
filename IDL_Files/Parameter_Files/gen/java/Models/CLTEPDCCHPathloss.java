
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCHPathloss extends CRadioMeasParam
{
    public Double mPDCCHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDCCHPathloss)))
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

            mPDCCHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCHPathloss = info.mPDCCHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCHPathloss = null;
    }

    public String ToString()
    {
        if (mPDCCHPathloss == null)
            return "";
        else
            return String.format("%s", mPDCCHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCHPathloss";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHPathloss extends CRadioMeasParam
{
    public Double mPDSCHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHPathloss)))
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

            mPDSCHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHPathloss = info.mPDSCHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHPathloss = null;
    }

    public String ToString()
    {
        if (mPDSCHPathloss == null)
            return "";
        else
            return String.format("%s", mPDSCHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHPathloss";
    }
}

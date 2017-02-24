
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHPathloss extends CRadioMeasParam
{
    public Double mPUSCHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHPathloss)))
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

            mPUSCHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHPathloss = info.mPUSCHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHPathloss = null;
    }

    public String ToString()
    {
        if (mPUSCHPathloss == null)
            return "";
        else
            return String.format("%s", mPUSCHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHPathloss";
    }
}

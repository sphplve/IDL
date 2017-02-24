
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHAlpha extends CRadioMeasParam
{
    public Double mPUSCHAlpha;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHAlpha")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHAlpha)))
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

            mPUSCHAlpha = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHAlpha info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHAlpha = info.mPUSCHAlpha;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHAlpha = null;
    }

    public String ToString()
    {
        if (mPUSCHAlpha == null)
            return "";
        else
            return String.format("%s", mPUSCHAlpha);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHAlpha";
    }
}

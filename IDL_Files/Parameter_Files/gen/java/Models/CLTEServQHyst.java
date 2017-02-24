
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEServQHyst extends CRadioMeasParam
{
    public Double mServQHyst;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEServQHyst")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mServQHyst)))
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

            mServQHyst = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEServQHyst info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mServQHyst = info.mServQHyst;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mServQHyst = null;
    }

    public String ToString()
    {
        if (mServQHyst == null)
            return "";
        else
            return String.format("%s", mServQHyst);
    }

    public String GetTypeName()
    {
        return "Models.CLTEServQHyst";
    }
}

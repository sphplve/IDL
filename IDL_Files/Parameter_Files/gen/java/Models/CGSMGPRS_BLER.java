
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMGPRS_BLER extends CRadioMeasParam
{
    public Double mGPRS_BLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMGPRS_BLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mGPRS_BLER)))
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

            mGPRS_BLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMGPRS_BLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGPRS_BLER = info.mGPRS_BLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGPRS_BLER = null;
    }

    public String ToString()
    {
        if (mGPRS_BLER == null)
            return "";
        else
            return String.format("%s", mGPRS_BLER);
    }

    public String GetTypeName()
    {
        return "Models.CGSMGPRS_BLER";
    }
}

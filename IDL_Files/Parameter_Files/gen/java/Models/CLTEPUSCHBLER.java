
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHBLER extends CRadioMeasParam
{
    public Double mPUSCHBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHBLER)))
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

            mPUSCHBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHBLER = info.mPUSCHBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHBLER = null;
    }

    public String ToString()
    {
        if (mPUSCHBLER == null)
            return "";
        else
            return String.format("%s", mPUSCHBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHBLER";
    }
}

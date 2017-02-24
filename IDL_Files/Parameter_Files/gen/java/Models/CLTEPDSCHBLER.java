
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHBLER extends CRadioMeasParam
{
    public Double mPDSCHBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHBLER)))
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

            mPDSCHBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHBLER = info.mPDSCHBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHBLER";
    }
}

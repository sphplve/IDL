
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHCode1ResidualBLER extends CRadioMeasParam
{
    public Double mPDSCHCode1ResidualBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHCode1ResidualBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHCode1ResidualBLER)))
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

            mPDSCHCode1ResidualBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHCode1ResidualBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHCode1ResidualBLER = info.mPDSCHCode1ResidualBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHCode1ResidualBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHCode1ResidualBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHCode1ResidualBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHCode1ResidualBLER";
    }
}

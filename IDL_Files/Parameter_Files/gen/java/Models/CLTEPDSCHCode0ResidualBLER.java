
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHCode0ResidualBLER extends CRadioMeasParam
{
    public Double mPDSCHCode0ResidualBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHCode0ResidualBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHCode0ResidualBLER)))
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

            mPDSCHCode0ResidualBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHCode0ResidualBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHCode0ResidualBLER = info.mPDSCHCode0ResidualBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHCode0ResidualBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHCode0ResidualBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHCode0ResidualBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHCode0ResidualBLER";
    }
}

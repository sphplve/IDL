
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHResidualBLER extends CRadioMeasParam
{
    public Double mPDSCHResidualBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHResidualBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHResidualBLER)))
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

            mPDSCHResidualBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHResidualBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHResidualBLER = info.mPDSCHResidualBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHResidualBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHResidualBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHResidualBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHResidualBLER";
    }
}

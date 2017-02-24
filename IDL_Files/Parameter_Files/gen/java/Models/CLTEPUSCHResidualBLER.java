
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHResidualBLER extends CRadioMeasParam
{
    public Double mPUSCHResidualBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHResidualBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHResidualBLER)))
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

            mPUSCHResidualBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHResidualBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHResidualBLER = info.mPUSCHResidualBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHResidualBLER = null;
    }

    public String ToString()
    {
        if (mPUSCHResidualBLER == null)
            return "";
        else
            return String.format("%s", mPUSCHResidualBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHResidualBLER";
    }
}

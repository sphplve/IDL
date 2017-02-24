
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHCode1InitialBLER extends CRadioMeasParam
{
    public Double mPDSCHCode1InitialBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHCode1InitialBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHCode1InitialBLER)))
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

            mPDSCHCode1InitialBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHCode1InitialBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHCode1InitialBLER = info.mPDSCHCode1InitialBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHCode1InitialBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHCode1InitialBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHCode1InitialBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHCode1InitialBLER";
    }
}

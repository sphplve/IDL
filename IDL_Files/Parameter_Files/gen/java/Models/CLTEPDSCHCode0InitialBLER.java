
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHCode0InitialBLER extends CRadioMeasParam
{
    public Double mPDSCHCode0InitialBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHCode0InitialBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDSCHCode0InitialBLER)))
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

            mPDSCHCode0InitialBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHCode0InitialBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHCode0InitialBLER = info.mPDSCHCode0InitialBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHCode0InitialBLER = null;
    }

    public String ToString()
    {
        if (mPDSCHCode0InitialBLER == null)
            return "";
        else
            return String.format("%s", mPDSCHCode0InitialBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHCode0InitialBLER";
    }
}

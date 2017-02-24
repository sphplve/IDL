
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDNAddress extends CRadioMeasParam
{
    public String mPDNAddress;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDNAddress")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPDNAddress)))
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

            mPDNAddress = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDNAddress info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDNAddress = info.mPDNAddress;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDNAddress = null;
    }

    public String ToString()
    {
        if (mPDNAddress == null)
            return String.format("");
        else
            return mPDNAddress;
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDNAddress";
    }
}

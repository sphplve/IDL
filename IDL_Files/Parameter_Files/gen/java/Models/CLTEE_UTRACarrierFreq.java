
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEE_UTRACarrierFreq extends CRadioMeasParam
{
    public Integer mE_UTRACarrierFreq;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEE_UTRACarrierFreq")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mE_UTRACarrierFreq)))
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

            mE_UTRACarrierFreq = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEE_UTRACarrierFreq info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mE_UTRACarrierFreq = info.mE_UTRACarrierFreq;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mE_UTRACarrierFreq = null;
    }

    public String ToString()
    {
        if (mE_UTRACarrierFreq == null)
            return "";
        else
            return String.format("%s", mE_UTRACarrierFreq);
    }

    public String GetTypeName()
    {
        return "Models.CLTEE_UTRACarrierFreq";
    }
}

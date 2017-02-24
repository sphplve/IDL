
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSM8PSK_CV_BEP extends CRadioMeasParam
{
    public Integer m8PSK_CV_BEP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSM8PSK_CV_BEP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(m8PSK_CV_BEP)))
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

            m8PSK_CV_BEP = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSM8PSK_CV_BEP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        m8PSK_CV_BEP = info.m8PSK_CV_BEP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        m8PSK_CV_BEP = null;
    }

    public String ToString()
    {
        if (m8PSK_CV_BEP == null)
            return "";
        else
            return String.format("%s", m8PSK_CV_BEP);
    }

    public String GetTypeName()
    {
        return "Models.CGSM8PSK_CV_BEP";
    }
}

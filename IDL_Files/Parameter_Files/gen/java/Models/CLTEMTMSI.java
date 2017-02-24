
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMTMSI extends CRadioMeasParam
{
    public Integer mMTMSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMTMSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mMTMSI)))
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

            mMTMSI = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMTMSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMTMSI = info.mMTMSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMTMSI = null;
    }

    public String ToString()
    {
        if (mMTMSI == null)
            return "";
        else
            return String.format("%s", mMTMSI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMTMSI";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASTMSI extends CRadioMeasParam
{
    public Integer mTMSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASTMSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mTMSI)))
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

            mTMSI = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASTMSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTMSI = info.mTMSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTMSI = null;
    }

    public String ToString()
    {
        if (mTMSI == null)
            return "";
        else
            return String.format("%s", mTMSI);
    }

    public String GetTypeName()
    {
        return "Models.CNASTMSI";
    }
}

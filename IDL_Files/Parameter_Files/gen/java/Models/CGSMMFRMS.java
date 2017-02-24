
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMFRMS extends CRadioMeasParam
{
    public Short mMFRMS;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMFRMS")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMFRMS)))
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

            mMFRMS = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMFRMS info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMFRMS = info.mMFRMS;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMFRMS = null;
    }

    public String ToString()
    {
        if (mMFRMS == null)
            return "";
        else
            return String.format("%s", mMFRMS);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMFRMS";
    }
}

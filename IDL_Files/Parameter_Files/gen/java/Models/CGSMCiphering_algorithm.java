
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCiphering_algorithm extends CRadioMeasParam
{
    public String mCiphering_algorithm;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCiphering_algorithm")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mCiphering_algorithm)))
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

            mCiphering_algorithm = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCiphering_algorithm info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCiphering_algorithm = info.mCiphering_algorithm;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCiphering_algorithm = null;
    }

    public String ToString()
    {
        if (mCiphering_algorithm == null)
            return String.format("");
        else
            return mCiphering_algorithm;
    }

    public String GetTypeName()
    {
        return "Models.CGSMCiphering_algorithm";
    }
}

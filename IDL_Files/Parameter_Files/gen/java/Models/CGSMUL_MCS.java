
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMUL_MCS extends CRadioMeasParam
{
    public String mUL_MCS;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMUL_MCS")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mUL_MCS)))
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

            mUL_MCS = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMUL_MCS info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_MCS = info.mUL_MCS;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_MCS = null;
    }

    public String ToString()
    {
        if (mUL_MCS == null)
            return String.format("");
        else
            return mUL_MCS;
    }

    public String GetTypeName()
    {
        return "Models.CGSMUL_MCS";
    }
}

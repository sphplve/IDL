
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_MCS extends CRadioMeasParam
{
    public String mDL_MCS;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_MCS")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mDL_MCS)))
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

            mDL_MCS = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_MCS info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_MCS = info.mDL_MCS;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_MCS = null;
    }

    public String ToString()
    {
        if (mDL_MCS == null)
            return String.format("");
        else
            return mDL_MCS;
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_MCS";
    }
}

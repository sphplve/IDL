
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECellAllowedAccess extends CRadioMeasParam
{
    public String mCellAllowedAccess;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECellAllowedAccess")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mCellAllowedAccess)))
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

            mCellAllowedAccess = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECellAllowedAccess info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellAllowedAccess = info.mCellAllowedAccess;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellAllowedAccess = null;
    }

    public String ToString()
    {
        if (mCellAllowedAccess == null)
            return String.format("");
        else
            return mCellAllowedAccess;
    }

    public String GetTypeName()
    {
        return "Models.CLTECellAllowedAccess";
    }
}

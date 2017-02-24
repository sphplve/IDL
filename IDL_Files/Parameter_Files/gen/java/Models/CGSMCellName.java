
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCellName extends CRadioMeasParam
{
    public String mCellName;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCellName")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mCellName)))
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

            mCellName = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCellName info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellName = info.mCellName;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellName = null;
    }

    public String ToString()
    {
        if (mCellName == null)
            return String.format("");
        else
            return mCellName;
    }

    public String GetTypeName()
    {
        return "Models.CGSMCellName";
    }
}

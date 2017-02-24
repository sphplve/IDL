
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCellId extends CRadioMeasParam
{
    public Integer mCellId;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCellId")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCellId)))
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

            mCellId = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCellId info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellId = info.mCellId;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellId = null;
    }

    public String ToString()
    {
        if (mCellId == null)
            return "";
        else
            return String.format("%s", mCellId);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCellId";
    }
}

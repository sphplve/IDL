
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCellSelectionPriority extends CRadioMeasParam
{
    public Short mCellSelectionPriority;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCellSelectionPriority")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCellSelectionPriority)))
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

            mCellSelectionPriority = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCellSelectionPriority info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellSelectionPriority = info.mCellSelectionPriority;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellSelectionPriority = null;
    }

    public String ToString()
    {
        if (mCellSelectionPriority == null)
            return "";
        else
            return String.format("%s", mCellSelectionPriority);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCellSelectionPriority";
    }
}

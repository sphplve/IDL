
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECellReselectPriority extends CRadioMeasParam
{
    public Integer mCellReselectPriority;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECellReselectPriority")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCellReselectPriority)))
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

            mCellReselectPriority = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECellReselectPriority info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellReselectPriority = info.mCellReselectPriority;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellReselectPriority = null;
    }

    public String ToString()
    {
        if (mCellReselectPriority == null)
            return "";
        else
            return String.format("%s", mCellReselectPriority);
    }

    public String GetTypeName()
    {
        return "Models.CLTECellReselectPriority";
    }
}

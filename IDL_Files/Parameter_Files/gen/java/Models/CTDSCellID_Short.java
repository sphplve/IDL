
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCellID_Short extends CRadioMeasParam
{
    public Integer mCellID_Short;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCellID_Short")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCellID_Short)))
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

            mCellID_Short = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCellID_Short info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellID_Short = info.mCellID_Short;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellID_Short = null;
    }

    public String ToString()
    {
        if (mCellID_Short == null)
            return "";
        else
            return String.format("%s", mCellID_Short);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCellID_Short";
    }
}

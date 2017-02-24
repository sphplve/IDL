
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECellID extends CRadioMeasParam
{
    public Integer mCellID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECellID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mCellID)))
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

            mCellID = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECellID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellID = info.mCellID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellID = null;
    }

    public String ToString()
    {
        if (mCellID == null)
            return "";
        else
            return String.format("%s", mCellID);
    }

    public String GetTypeName()
    {
        return "Models.CLTECellID";
    }
}

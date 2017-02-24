
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESectorID extends CRadioMeasParam
{
    public Short mSectorID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESectorID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mSectorID)))
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

            mSectorID = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESectorID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSectorID = info.mSectorID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSectorID = null;
    }

    public String ToString()
    {
        if (mSectorID == null)
            return "";
        else
            return String.format("%s", mSectorID);
    }

    public String GetTypeName()
    {
        return "Models.CLTESectorID";
    }
}

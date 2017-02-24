
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSURAID extends CRadioMeasParam
{
    public Integer mURAID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSURAID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mURAID)))
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

            mURAID = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSURAID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mURAID = info.mURAID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mURAID = null;
    }

    public String ToString()
    {
        if (mURAID == null)
            return "";
        else
            return String.format("%s", mURAID);
    }

    public String GetTypeName()
    {
        return "Models.CTDSURAID";
    }
}

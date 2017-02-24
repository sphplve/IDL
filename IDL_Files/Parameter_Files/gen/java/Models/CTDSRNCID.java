
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSRNCID extends CRadioMeasParam
{
    public Integer mRNCID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRNCID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRNCID)))
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

            mRNCID = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRNCID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRNCID = info.mRNCID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRNCID = null;
    }

    public String ToString()
    {
        if (mRNCID == null)
            return "";
        else
            return String.format("%s", mRNCID);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRNCID";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMNC extends CRadioMeasParam
{
    public Integer mMNC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMNC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMNC)))
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

            mMNC = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMNC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMNC = info.mMNC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMNC = null;
    }

    public String ToString()
    {
        if (mMNC == null)
            return "";
        else
            return String.format("%s", mMNC);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMNC";
    }
}

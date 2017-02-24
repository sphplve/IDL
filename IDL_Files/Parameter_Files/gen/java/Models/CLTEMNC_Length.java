
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMNC_Length extends CRadioMeasParam
{
    public Byte mMNC_Length;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMNC_Length")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mMNC_Length)))
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

            mMNC_Length = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMNC_Length info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMNC_Length = info.mMNC_Length;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMNC_Length = null;
    }

    public String ToString()
    {
        if (mMNC_Length == null)
            return "";
        else
            return String.format("%s", mMNC_Length);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMNC_Length";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRandomNumberPart4 extends CRadioMeasParam
{
    public Integer mRandomNumberPart4;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRandomNumberPart4")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mRandomNumberPart4)))
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

            mRandomNumberPart4 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRandomNumberPart4 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRandomNumberPart4 = info.mRandomNumberPart4;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRandomNumberPart4 = null;
    }

    public String ToString()
    {
        if (mRandomNumberPart4 == null)
            return "";
        else
            return String.format("%s", mRandomNumberPart4);
    }

    public String GetTypeName()
    {
        return "Models.CNASRandomNumberPart4";
    }
}

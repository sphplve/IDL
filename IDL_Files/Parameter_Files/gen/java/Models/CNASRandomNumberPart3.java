
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRandomNumberPart3 extends CRadioMeasParam
{
    public Integer mRandomNumberPart3;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRandomNumberPart3")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mRandomNumberPart3)))
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

            mRandomNumberPart3 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRandomNumberPart3 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRandomNumberPart3 = info.mRandomNumberPart3;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRandomNumberPart3 = null;
    }

    public String ToString()
    {
        if (mRandomNumberPart3 == null)
            return "";
        else
            return String.format("%s", mRandomNumberPart3);
    }

    public String GetTypeName()
    {
        return "Models.CNASRandomNumberPart3";
    }
}

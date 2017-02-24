
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRandomNumberPart2 extends CRadioMeasParam
{
    public Integer mRandomNumberPart2;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRandomNumberPart2")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mRandomNumberPart2)))
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

            mRandomNumberPart2 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRandomNumberPart2 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRandomNumberPart2 = info.mRandomNumberPart2;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRandomNumberPart2 = null;
    }

    public String ToString()
    {
        if (mRandomNumberPart2 == null)
            return "";
        else
            return String.format("%s", mRandomNumberPart2);
    }

    public String GetTypeName()
    {
        return "Models.CNASRandomNumberPart2";
    }
}

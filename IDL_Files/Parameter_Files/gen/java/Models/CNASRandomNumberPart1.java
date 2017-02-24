
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRandomNumberPart1 extends CRadioMeasParam
{
    public Integer mRandomNumberPart1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRandomNumberPart1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mRandomNumberPart1)))
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

            mRandomNumberPart1 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRandomNumberPart1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRandomNumberPart1 = info.mRandomNumberPart1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRandomNumberPart1 = null;
    }

    public String ToString()
    {
        if (mRandomNumberPart1 == null)
            return "";
        else
            return String.format("%s", mRandomNumberPart1);
    }

    public String GetTypeName()
    {
        return "Models.CNASRandomNumberPart1";
    }
}

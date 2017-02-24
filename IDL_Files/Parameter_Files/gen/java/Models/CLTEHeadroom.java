
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEHeadroom extends CRadioMeasParam
{
    public Double mHeadroom;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEHeadroom")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mHeadroom)))
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

            mHeadroom = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEHeadroom info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHeadroom = info.mHeadroom;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHeadroom = null;
    }

    public String ToString()
    {
        if (mHeadroom == null)
            return "";
        else
            return String.format("%s", mHeadroom);
    }

    public String GetTypeName()
    {
        return "Models.CLTEHeadroom";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSRS extends CRadioMeasParam
{
    public Integer mRS;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRS")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mRS)))
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

            mRS = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRS info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRS = info.mRS;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRS = null;
    }

    public String ToString()
    {
        if (mRS == null)
            return "";
        else
            return String.format("%s", mRS);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRS";
    }
}

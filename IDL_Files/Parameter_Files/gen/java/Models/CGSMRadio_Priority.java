
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRadio_Priority extends CRadioMeasParam
{
    public Short mRadio_Priority;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRadio_Priority")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRadio_Priority)))
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

            mRadio_Priority = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRadio_Priority info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRadio_Priority = info.mRadio_Priority;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRadio_Priority = null;
    }

    public String ToString()
    {
        if (mRadio_Priority == null)
            return "";
        else
            return String.format("%s", mRadio_Priority);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRadio_Priority";
    }
}

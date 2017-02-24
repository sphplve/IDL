
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUuTimingAdvance extends CRadioMeasParam
{
    public Integer mUuTimingAdvance;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUuTimingAdvance")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUuTimingAdvance)))
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

            mUuTimingAdvance = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUuTimingAdvance info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUuTimingAdvance = info.mUuTimingAdvance;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUuTimingAdvance = null;
    }

    public String ToString()
    {
        if (mUuTimingAdvance == null)
            return "";
        else
            return String.format("%s", mUuTimingAdvance);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUuTimingAdvance";
    }
}

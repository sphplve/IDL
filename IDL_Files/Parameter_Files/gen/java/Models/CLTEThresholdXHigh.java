
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThresholdXHigh extends CRadioMeasParam
{
    public Integer mThresholdXHigh;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThresholdXHigh")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThresholdXHigh)))
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

            mThresholdXHigh = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThresholdXHigh info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThresholdXHigh = info.mThresholdXHigh;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThresholdXHigh = null;
    }

    public String ToString()
    {
        if (mThresholdXHigh == null)
            return "";
        else
            return String.format("%s", mThresholdXHigh);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThresholdXHigh";
    }
}

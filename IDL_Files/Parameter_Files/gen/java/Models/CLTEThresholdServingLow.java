
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThresholdServingLow extends CRadioMeasParam
{
    public Integer mThresholdServingLow;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThresholdServingLow")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThresholdServingLow)))
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

            mThresholdServingLow = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThresholdServingLow info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThresholdServingLow = info.mThresholdServingLow;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThresholdServingLow = null;
    }

    public String ToString()
    {
        if (mThresholdServingLow == null)
            return "";
        else
            return String.format("%s", mThresholdServingLow);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThresholdServingLow";
    }
}

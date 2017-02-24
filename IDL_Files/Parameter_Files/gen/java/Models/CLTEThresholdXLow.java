
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThresholdXLow extends CRadioMeasParam
{
    public Integer mThresholdXLow;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThresholdXLow")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThresholdXLow)))
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

            mThresholdXLow = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThresholdXLow info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThresholdXLow = info.mThresholdXLow;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThresholdXLow = null;
    }

    public String ToString()
    {
        if (mThresholdXLow == null)
            return "";
        else
            return String.format("%s", mThresholdXLow);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThresholdXLow";
    }
}

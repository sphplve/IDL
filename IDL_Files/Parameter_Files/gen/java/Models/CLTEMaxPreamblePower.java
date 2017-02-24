
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMaxPreamblePower extends CRadioMeasParam
{
    public Short mMaxPreamblePower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMaxPreamblePower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mMaxPreamblePower)))
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

            mMaxPreamblePower = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMaxPreamblePower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaxPreamblePower = info.mMaxPreamblePower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaxPreamblePower = null;
    }

    public String ToString()
    {
        if (mMaxPreamblePower == null)
            return "";
        else
            return String.format("%s", mMaxPreamblePower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMaxPreamblePower";
    }
}

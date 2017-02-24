
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMaxRxLevel extends CRadioMeasParam
{
    public Double mMaxRxLevel;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMaxRxLevel")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mMaxRxLevel)))
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

            mMaxRxLevel = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMaxRxLevel info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaxRxLevel = info.mMaxRxLevel;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaxRxLevel = null;
    }

    public String ToString()
    {
        if (mMaxRxLevel == null)
            return "";
        else
            return String.format("%s", mMaxRxLevel);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMaxRxLevel";
    }
}

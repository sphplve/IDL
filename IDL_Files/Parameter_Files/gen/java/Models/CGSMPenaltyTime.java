
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMPenaltyTime extends CRadioMeasParam
{
    public Short mPenaltyTime;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMPenaltyTime")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPenaltyTime)))
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

            mPenaltyTime = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMPenaltyTime info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPenaltyTime = info.mPenaltyTime;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPenaltyTime = null;
    }

    public String ToString()
    {
        if (mPenaltyTime == null)
            return "";
        else
            return String.format("%s", mPenaltyTime);
    }

    public String GetTypeName()
    {
        return "Models.CGSMPenaltyTime";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_Timeslot extends CRadioMeasParam
{
    public Short mPRACH_Timeslot;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_Timeslot")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPRACH_Timeslot)))
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

            mPRACH_Timeslot = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_Timeslot info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_Timeslot = info.mPRACH_Timeslot;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_Timeslot = null;
    }

    public String ToString()
    {
        if (mPRACH_Timeslot == null)
            return "";
        else
            return String.format("%s", mPRACH_Timeslot);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_Timeslot";
    }
}

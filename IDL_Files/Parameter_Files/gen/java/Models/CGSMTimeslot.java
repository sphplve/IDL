
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTimeslot extends CRadioMeasParam
{
    public Short mTimeslot;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTimeslot")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTimeslot)))
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

            mTimeslot = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTimeslot info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTimeslot = info.mTimeslot;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTimeslot = null;
    }

    public String ToString()
    {
        if (mTimeslot == null)
            return "";
        else
            return String.format("%s", mTimeslot);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTimeslot";
    }
}

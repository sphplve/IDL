
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRouting_Area_Update_Reject_Cause extends CRadioMeasParam
{
    public Short mRouting_Area_Update_Reject_Cause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRouting_Area_Update_Reject_Cause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRouting_Area_Update_Reject_Cause)))
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

            mRouting_Area_Update_Reject_Cause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRouting_Area_Update_Reject_Cause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRouting_Area_Update_Reject_Cause = info.mRouting_Area_Update_Reject_Cause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRouting_Area_Update_Reject_Cause = null;
    }

    public String ToString()
    {
        if (mRouting_Area_Update_Reject_Cause == null)
            return "";
        else
            return String.format("%s", mRouting_Area_Update_Reject_Cause);
    }

    public String GetTypeName()
    {
        return "Models.CNASRouting_Area_Update_Reject_Cause";
    }
}

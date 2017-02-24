
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMPriority_Access_THR extends CRadioMeasParam
{
    public Short mPriority_Access_THR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMPriority_Access_THR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPriority_Access_THR)))
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

            mPriority_Access_THR = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMPriority_Access_THR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPriority_Access_THR = info.mPriority_Access_THR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPriority_Access_THR = null;
    }

    public String ToString()
    {
        if (mPriority_Access_THR == null)
            return "";
        else
            return String.format("%s", mPriority_Access_THR);
    }

    public String GetTypeName()
    {
        return "Models.CGSMPriority_Access_THR";
    }
}

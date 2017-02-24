
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEENodeBID extends CRadioMeasParam
{
    public Integer mENodeBID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEENodeBID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mENodeBID)))
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

            mENodeBID = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEENodeBID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mENodeBID = info.mENodeBID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mENodeBID = null;
    }

    public String ToString()
    {
        if (mENodeBID == null)
            return "";
        else
            return String.format("%s", mENodeBID);
    }

    public String GetTypeName()
    {
        return "Models.CLTEENodeBID";
    }
}

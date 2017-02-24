
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMFERSub extends CRadioMeasParam
{
    public Double mFERSub;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMFERSub")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFERSub)))
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

            mFERSub = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMFERSub info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFERSub = info.mFERSub;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFERSub = null;
    }

    public String ToString()
    {
        if (mFERSub == null)
            return "";
        else
            return String.format("%s", mFERSub);
    }

    public String GetTypeName()
    {
        return "Models.CGSMFERSub";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMFERFull extends CRadioMeasParam
{
    public Double mFERFull;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMFERFull")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFERFull)))
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

            mFERFull = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMFERFull info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFERFull = info.mFERFull;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFERFull = null;
    }

    public String ToString()
    {
        if (mFERFull == null)
            return "";
        else
            return String.format("%s", mFERFull);
    }

    public String GetTypeName()
    {
        return "Models.CGSMFERFull";
    }
}

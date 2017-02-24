
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFourthReTxUL extends CRadioMeasParam
{
    public Integer mFourthReTxUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFourthReTxUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFourthReTxUL)))
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

            mFourthReTxUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFourthReTxUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFourthReTxUL = info.mFourthReTxUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFourthReTxUL = null;
    }

    public String ToString()
    {
        if (mFourthReTxUL == null)
            return "";
        else
            return String.format("%s", mFourthReTxUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFourthReTxUL";
    }
}

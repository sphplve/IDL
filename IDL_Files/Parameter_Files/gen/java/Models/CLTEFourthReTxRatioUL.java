
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFourthReTxRatioUL extends CRadioMeasParam
{
    public Double mFourthReTxRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFourthReTxRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFourthReTxRatioUL)))
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

            mFourthReTxRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFourthReTxRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFourthReTxRatioUL = info.mFourthReTxRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFourthReTxRatioUL = null;
    }

    public String ToString()
    {
        if (mFourthReTxRatioUL == null)
            return "";
        else
            return String.format("%s", mFourthReTxRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFourthReTxRatioUL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEReTxFailureRatioUL extends CRadioMeasParam
{
    public Double mReTxFailureRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEReTxFailureRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mReTxFailureRatioUL)))
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

            mReTxFailureRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEReTxFailureRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReTxFailureRatioUL = info.mReTxFailureRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReTxFailureRatioUL = null;
    }

    public String ToString()
    {
        if (mReTxFailureRatioUL == null)
            return "";
        else
            return String.format("%s", mReTxFailureRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEReTxFailureRatioUL";
    }
}

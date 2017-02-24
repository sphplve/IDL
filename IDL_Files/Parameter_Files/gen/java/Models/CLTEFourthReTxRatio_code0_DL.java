
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFourthReTxRatio_code0_DL extends CRadioMeasParam
{
    public Double mFourthReTxRatio_code0_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFourthReTxRatio_code0_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFourthReTxRatio_code0_DL)))
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

            mFourthReTxRatio_code0_DL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFourthReTxRatio_code0_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFourthReTxRatio_code0_DL = info.mFourthReTxRatio_code0_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFourthReTxRatio_code0_DL = null;
    }

    public String ToString()
    {
        if (mFourthReTxRatio_code0_DL == null)
            return "";
        else
            return String.format("%s", mFourthReTxRatio_code0_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFourthReTxRatio_code0_DL";
    }
}

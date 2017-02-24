
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTxRatioUL extends CRadioMeasParam
{
    public Double mThirdReTxRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTxRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mThirdReTxRatioUL)))
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

            mThirdReTxRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTxRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTxRatioUL = info.mThirdReTxRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTxRatioUL = null;
    }

    public String ToString()
    {
        if (mThirdReTxRatioUL == null)
            return "";
        else
            return String.format("%s", mThirdReTxRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTxRatioUL";
    }
}

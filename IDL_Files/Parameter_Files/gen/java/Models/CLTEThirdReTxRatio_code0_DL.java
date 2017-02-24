
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTxRatio_code0_DL extends CRadioMeasParam
{
    public Double mThirdReTxRatio_code0_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTxRatio_code0_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mThirdReTxRatio_code0_DL)))
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

            mThirdReTxRatio_code0_DL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTxRatio_code0_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTxRatio_code0_DL = info.mThirdReTxRatio_code0_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTxRatio_code0_DL = null;
    }

    public String ToString()
    {
        if (mThirdReTxRatio_code0_DL == null)
            return "";
        else
            return String.format("%s", mThirdReTxRatio_code0_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTxRatio_code0_DL";
    }
}

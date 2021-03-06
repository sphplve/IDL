﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTxRatio_code1_DL extends CRadioMeasParam
{
    public Double mSecondReTxRatio_code1_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTxRatio_code1_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSecondReTxRatio_code1_DL)))
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

            mSecondReTxRatio_code1_DL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTxRatio_code1_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTxRatio_code1_DL = info.mSecondReTxRatio_code1_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTxRatio_code1_DL = null;
    }

    public String ToString()
    {
        if (mSecondReTxRatio_code1_DL == null)
            return "";
        else
            return String.format("%s", mSecondReTxRatio_code1_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTxRatio_code1_DL";
    }
}

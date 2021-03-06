﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTxRatioUL extends CRadioMeasParam
{
    public Double mSecondReTxRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTxRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSecondReTxRatioUL)))
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

            mSecondReTxRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTxRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTxRatioUL = info.mSecondReTxRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTxRatioUL = null;
    }

    public String ToString()
    {
        if (mSecondReTxRatioUL == null)
            return "";
        else
            return String.format("%s", mSecondReTxRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTxRatioUL";
    }
}

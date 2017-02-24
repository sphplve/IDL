﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTx_code1_DL extends CRadioMeasParam
{
    public Integer mThirdReTx_code1_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTx_code1_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThirdReTx_code1_DL)))
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

            mThirdReTx_code1_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTx_code1_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTx_code1_DL = info.mThirdReTx_code1_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTx_code1_DL = null;
    }

    public String ToString()
    {
        if (mThirdReTx_code1_DL == null)
            return "";
        else
            return String.format("%s", mThirdReTx_code1_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTx_code1_DL";
    }
}

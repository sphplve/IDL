﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstReTx_code1_DL extends CRadioMeasParam
{
    public Integer mFirstReTx_code1_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstReTx_code1_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstReTx_code1_DL)))
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

            mFirstReTx_code1_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstReTx_code1_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstReTx_code1_DL = info.mFirstReTx_code1_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstReTx_code1_DL = null;
    }

    public String ToString()
    {
        if (mFirstReTx_code1_DL == null)
            return "";
        else
            return String.format("%s", mFirstReTx_code1_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstReTx_code1_DL";
    }
}

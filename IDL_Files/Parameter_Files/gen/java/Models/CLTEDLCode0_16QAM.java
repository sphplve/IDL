﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode0_16QAM extends CRadioMeasParam
{
    public Double mDLCode0_16QAM;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode0_16QAM")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDLCode0_16QAM)))
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

            mDLCode0_16QAM = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode0_16QAM info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode0_16QAM = info.mDLCode0_16QAM;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode0_16QAM = null;
    }

    public String ToString()
    {
        if (mDLCode0_16QAM == null)
            return "";
        else
            return String.format("%s", mDLCode0_16QAM);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode0_16QAM";
    }
}

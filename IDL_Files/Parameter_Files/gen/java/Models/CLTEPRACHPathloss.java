﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPRACHPathloss extends CRadioMeasParam
{
    public Double mPRACHPathloss;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPRACHPathloss")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPRACHPathloss)))
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

            mPRACHPathloss = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPRACHPathloss info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACHPathloss = info.mPRACHPathloss;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACHPathloss = null;
    }

    public String ToString()
    {
        if (mPRACHPathloss == null)
            return "";
        else
            return String.format("%s", mPRACHPathloss);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPRACHPathloss";
    }
}

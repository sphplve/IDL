﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASGMMState_W extends CRadioMeasParam
{
    public Short mGMMState_W;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASGMMState_W")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mGMMState_W)))
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

            mGMMState_W = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASGMMState_W info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGMMState_W = info.mGMMState_W;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGMMState_W = null;
    }

    public String ToString()
    {
        if (mGMMState_W == null)
            return "";
        else
            return String.format("%s", mGMMState_W);
    }

    public String GetTypeName()
    {
        return "Models.CNASGMMState_W";
    }
}

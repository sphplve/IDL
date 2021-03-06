﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMNMO extends CRadioMeasParam
{
    public Short mNMO;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNMO")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNMO)))
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

            mNMO = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNMO info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNMO = info.mNMO;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNMO = null;
    }

    public String ToString()
    {
        if (mNMO == null)
            return "";
        else
            return String.format("%s", mNMO);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNMO";
    }
}

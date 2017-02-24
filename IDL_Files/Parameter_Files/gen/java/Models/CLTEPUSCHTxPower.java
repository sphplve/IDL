﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHTxPower extends CRadioMeasParam
{
    public Byte mPUSCHTxPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHTxPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mPUSCHTxPower)))
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

            mPUSCHTxPower = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHTxPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHTxPower = info.mPUSCHTxPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHTxPower = null;
    }

    public String ToString()
    {
        if (mPUSCHTxPower == null)
            return "";
        else
            return String.format("%s", mPUSCHTxPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHTxPower";
    }
}

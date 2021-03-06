﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMChannel_number extends CRadioMeasParam
{
    public Integer mChannel_number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMChannel_number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mChannel_number)))
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

            mChannel_number = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMChannel_number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mChannel_number = info.mChannel_number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mChannel_number = null;
    }

    public String ToString()
    {
        if (mChannel_number == null)
            return "";
        else
            return String.format("%s", mChannel_number);
    }

    public String GetTypeName()
    {
        return "Models.CGSMChannel_number";
    }
}

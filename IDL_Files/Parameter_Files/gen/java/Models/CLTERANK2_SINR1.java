﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERANK2_SINR1 extends CRadioMeasParam
{
    public Double mRANK2_SINR1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERANK2_SINR1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRANK2_SINR1)))
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

            mRANK2_SINR1 = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERANK2_SINR1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRANK2_SINR1 = info.mRANK2_SINR1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRANK2_SINR1 = null;
    }

    public String ToString()
    {
        if (mRANK2_SINR1 == null)
            return "";
        else
            return String.format("%s", mRANK2_SINR1);
    }

    public String GetTypeName()
    {
        return "Models.CLTERANK2_SINR1";
    }
}

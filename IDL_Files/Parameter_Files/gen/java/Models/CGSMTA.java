﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTA extends CRadioMeasParam
{
    public Integer mTA;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTA")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTA)))
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

            mTA = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTA info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTA = info.mTA;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTA = null;
    }

    public String ToString()
    {
        if (mTA == null)
            return "";
        else
            return String.format("%s", mTA);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTA";
    }
}

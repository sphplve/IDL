﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS5_DPCH_ISCP extends CRadioMeasParam
{
    public Double mTS5_DPCH_ISCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS5_DPCH_ISCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS5_DPCH_ISCP)))
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

            mTS5_DPCH_ISCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS5_DPCH_ISCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS5_DPCH_ISCP = info.mTS5_DPCH_ISCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS5_DPCH_ISCP = null;
    }

    public String ToString()
    {
        if (mTS5_DPCH_ISCP == null)
            return "";
        else
            return String.format("%s", mTS5_DPCH_ISCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS5_DPCH_ISCP";
    }
}

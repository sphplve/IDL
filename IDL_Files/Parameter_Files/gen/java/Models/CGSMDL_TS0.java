﻿
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_TS0 extends CRadioMeasParam
{
    public Short mDL_TS0;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_TS0")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDL_TS0)))
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

            mDL_TS0 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_TS0 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_TS0 = info.mDL_TS0;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_TS0 = null;
    }

    public String ToString()
    {
        if (mDL_TS0 == null)
            return "";
        else
            return String.format("%s", mDL_TS0);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_TS0";
    }
}

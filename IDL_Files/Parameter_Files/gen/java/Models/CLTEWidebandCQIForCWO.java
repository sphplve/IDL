
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEWidebandCQIForCWO extends CRadioMeasParam
{
    public Short mWidebandCQIForCWO;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEWidebandCQIForCWO")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mWidebandCQIForCWO)))
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

            mWidebandCQIForCWO = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEWidebandCQIForCWO info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWidebandCQIForCWO = info.mWidebandCQIForCWO;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWidebandCQIForCWO = null;
    }

    public String ToString()
    {
        if (mWidebandCQIForCWO == null)
            return "";
        else
            return String.format("%s", mWidebandCQIForCWO);
    }

    public String GetTypeName()
    {
        return "Models.CLTEWidebandCQIForCWO";
    }
}

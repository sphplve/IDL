
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEWidebandCQIForCW1 extends CRadioMeasParam
{
    public Short mWidebandCQIForCW1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEWidebandCQIForCW1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mWidebandCQIForCW1)))
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

            mWidebandCQIForCW1 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEWidebandCQIForCW1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWidebandCQIForCW1 = info.mWidebandCQIForCW1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWidebandCQIForCW1 = null;
    }

    public String ToString()
    {
        if (mWidebandCQIForCW1 == null)
            return "";
        else
            return String.format("%s", mWidebandCQIForCW1);
    }

    public String GetTypeName()
    {
        return "Models.CLTEWidebandCQIForCW1";
    }
}

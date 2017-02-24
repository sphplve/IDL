
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEULBandWidth extends CRadioMeasParam
{
    public Double mULBandWidth;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEULBandWidth")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mULBandWidth)))
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

            mULBandWidth = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEULBandWidth info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mULBandWidth = info.mULBandWidth;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mULBandWidth = null;
    }

    public String ToString()
    {
        if (mULBandWidth == null)
            return "";
        else
            return String.format("%s", mULBandWidth);
    }

    public String GetTypeName()
    {
        return "Models.CLTEULBandWidth";
    }
}

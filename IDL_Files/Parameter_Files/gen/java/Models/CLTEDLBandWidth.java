
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLBandWidth extends CRadioMeasParam
{
    public Double mDLBandWidth;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLBandWidth")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDLBandWidth)))
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

            mDLBandWidth = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLBandWidth info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLBandWidth = info.mDLBandWidth;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLBandWidth = null;
    }

    public String ToString()
    {
        if (mDLBandWidth == null)
            return "";
        else
            return String.format("%s", mDLBandWidth);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLBandWidth";
    }
}

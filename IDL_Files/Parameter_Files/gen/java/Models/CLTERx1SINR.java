
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx1SINR extends CRadioMeasParam
{
    public Double mRx1SINR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx1SINR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx1SINR)))
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

            mRx1SINR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx1SINR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx1SINR = info.mRx1SINR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx1SINR = null;
    }

    public String ToString()
    {
        if (mRx1SINR == null)
            return "";
        else
            return String.format("%s", mRx1SINR);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx1SINR";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx0SINR extends CRadioMeasParam
{
    public Double mRx0SINR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx0SINR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx0SINR)))
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

            mRx0SINR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx0SINR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx0SINR = info.mRx0SINR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx0SINR = null;
    }

    public String ToString()
    {
        if (mRx0SINR == null)
            return "";
        else
            return String.format("%s", mRx0SINR);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx0SINR";
    }
}

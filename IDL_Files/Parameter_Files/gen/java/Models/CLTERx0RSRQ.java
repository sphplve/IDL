
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx0RSRQ extends CRadioMeasParam
{
    public Double mRx0RSRQ;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx0RSRQ")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx0RSRQ)))
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

            mRx0RSRQ = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx0RSRQ info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx0RSRQ = info.mRx0RSRQ;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx0RSRQ = null;
    }

    public String ToString()
    {
        if (mRx0RSRQ == null)
            return "";
        else
            return String.format("%s", mRx0RSRQ);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx0RSRQ";
    }
}

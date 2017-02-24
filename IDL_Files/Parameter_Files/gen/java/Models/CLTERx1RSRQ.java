
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx1RSRQ extends CRadioMeasParam
{
    public Double mRx1RSRQ;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx1RSRQ")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx1RSRQ)))
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

            mRx1RSRQ = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx1RSRQ info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx1RSRQ = info.mRx1RSRQ;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx1RSRQ = null;
    }

    public String ToString()
    {
        if (mRx1RSRQ == null)
            return "";
        else
            return String.format("%s", mRx1RSRQ);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx1RSRQ";
    }
}

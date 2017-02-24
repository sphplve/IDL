
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx1RSRP extends CRadioMeasParam
{
    public Double mRx1RSRP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx1RSRP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx1RSRP)))
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

            mRx1RSRP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx1RSRP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx1RSRP = info.mRx1RSRP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx1RSRP = null;
    }

    public String ToString()
    {
        if (mRx1RSRP == null)
            return "";
        else
            return String.format("%s", mRx1RSRP);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx1RSRP";
    }
}

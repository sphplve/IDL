
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx0RSRP extends CRadioMeasParam
{
    public Double mRx0RSRP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx0RSRP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx0RSRP)))
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

            mRx0RSRP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx0RSRP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx0RSRP = info.mRx0RSRP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx0RSRP = null;
    }

    public String ToString()
    {
        if (mRx0RSRP == null)
            return "";
        else
            return String.format("%s", mRx0RSRP);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx0RSRP";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx0RSSI extends CRadioMeasParam
{
    public Double mRx0RSSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx0RSSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx0RSSI)))
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

            mRx0RSSI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx0RSSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx0RSSI = info.mRx0RSSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx0RSSI = null;
    }

    public String ToString()
    {
        if (mRx0RSSI == null)
            return "";
        else
            return String.format("%s", mRx0RSSI);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx0RSSI";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERx1RSSI extends CRadioMeasParam
{
    public Double mRx1RSSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERx1RSSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRx1RSSI)))
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

            mRx1RSSI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERx1RSSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRx1RSSI = info.mRx1RSSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRx1RSSI = null;
    }

    public String ToString()
    {
        if (mRx1RSSI == null)
            return "";
        else
            return String.format("%s", mRx1RSSI);
    }

    public String GetTypeName()
    {
        return "Models.CLTERx1RSSI";
    }
}

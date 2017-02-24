
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTrannsmissionChannelAverageBler extends CRadioMeasParam
{
    public Double mTrannsmissionChannelAverageBler;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTrannsmissionChannelAverageBler")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTrannsmissionChannelAverageBler)))
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

            mTrannsmissionChannelAverageBler = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTrannsmissionChannelAverageBler info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTrannsmissionChannelAverageBler = info.mTrannsmissionChannelAverageBler;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTrannsmissionChannelAverageBler = null;
    }

    public String ToString()
    {
        if (mTrannsmissionChannelAverageBler == null)
            return "";
        else
            return String.format("%s", mTrannsmissionChannelAverageBler);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTrannsmissionChannelAverageBler";
    }
}

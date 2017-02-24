
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSSRxlev extends CRadioMeasParam
{
    public Integer mSRxlev;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSSRxlev")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mSRxlev)))
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

            mSRxlev = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSSRxlev info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSRxlev = info.mSRxlev;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSRxlev = null;
    }

    public String ToString()
    {
        if (mSRxlev == null)
            return "";
        else
            return String.format("%s", mSRxlev);
    }

    public String GetTypeName()
    {
        return "Models.CTDSSRxlev";
    }
}

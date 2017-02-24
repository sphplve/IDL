
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHSDPA_Schedule_Modulation_Mode extends CRadioMeasParam
{
    public Short mHSDPA_Schedule_Modulation_Mode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHSDPA_Schedule_Modulation_Mode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHSDPA_Schedule_Modulation_Mode)))
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

            mHSDPA_Schedule_Modulation_Mode = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHSDPA_Schedule_Modulation_Mode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHSDPA_Schedule_Modulation_Mode = info.mHSDPA_Schedule_Modulation_Mode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHSDPA_Schedule_Modulation_Mode = null;
    }

    public String ToString()
    {
        if (mHSDPA_Schedule_Modulation_Mode == null)
            return "";
        else
            return String.format("%s", mHSDPA_Schedule_Modulation_Mode);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHSDPA_Schedule_Modulation_Mode";
    }
}

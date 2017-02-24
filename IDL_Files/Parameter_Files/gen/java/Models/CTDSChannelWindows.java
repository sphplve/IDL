
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSChannelWindows extends CRadioMeasParam
{
    public Short mChannelWindows;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSChannelWindows")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mChannelWindows)))
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

            mChannelWindows = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSChannelWindows info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mChannelWindows = info.mChannelWindows;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mChannelWindows = null;
    }

    public String ToString()
    {
        if (mChannelWindows == null)
            return "";
        else
            return String.format("%s", mChannelWindows);
    }

    public String GetTypeName()
    {
        return "Models.CTDSChannelWindows";
    }
}

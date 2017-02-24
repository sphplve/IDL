
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSBasicMidamble extends CRadioMeasParam
{
    public Integer mBasicMidamble;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSBasicMidamble")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBasicMidamble)))
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

            mBasicMidamble = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSBasicMidamble info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBasicMidamble = info.mBasicMidamble;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBasicMidamble = null;
    }

    public String ToString()
    {
        if (mBasicMidamble == null)
            return "";
        else
            return String.format("%s", mBasicMidamble);
    }

    public String GetTypeName()
    {
        return "Models.CTDSBasicMidamble";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCoefficient extends CRadioMeasParam
{
    public Long mCoefficient;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCoefficient")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mCoefficient)))
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

            mCoefficient = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCoefficient info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCoefficient = info.mCoefficient;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCoefficient = null;
    }

    public String ToString()
    {
        if (mCoefficient == null)
            return "";
        else
            return String.format("%s", mCoefficient);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCoefficient";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMATTIMSI extends CRadioMeasParam
{
    public Short mATTIMSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMATTIMSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mATTIMSI)))
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

            mATTIMSI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMATTIMSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mATTIMSI = info.mATTIMSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mATTIMSI = null;
    }

    public String ToString()
    {
        if (mATTIMSI == null)
            return "";
        else
            return String.format("%s", mATTIMSI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMATTIMSI";
    }
}

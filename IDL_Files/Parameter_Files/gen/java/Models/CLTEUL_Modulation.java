
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_Modulation extends CRadioMeasParam
{
    public Short mUL_Modulation;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_Modulation")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mUL_Modulation)))
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

            mUL_Modulation = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_Modulation info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_Modulation = info.mUL_Modulation;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_Modulation = null;
    }

    public String ToString()
    {
        if (mUL_Modulation == null)
            return "";
        else
            return String.format("%s", mUL_Modulation);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_Modulation";
    }
}

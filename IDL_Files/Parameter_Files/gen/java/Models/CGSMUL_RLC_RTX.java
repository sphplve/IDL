
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMUL_RLC_RTX extends CRadioMeasParam
{
    public Double mUL_RLC_RTX;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMUL_RLC_RTX")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_RLC_RTX)))
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

            mUL_RLC_RTX = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMUL_RLC_RTX info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_RLC_RTX = info.mUL_RLC_RTX;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_RLC_RTX = null;
    }

    public String ToString()
    {
        if (mUL_RLC_RTX == null)
            return "";
        else
            return String.format("%s", mUL_RLC_RTX);
    }

    public String GetTypeName()
    {
        return "Models.CGSMUL_RLC_RTX";
    }
}

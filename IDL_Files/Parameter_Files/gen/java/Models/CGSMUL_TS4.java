
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMUL_TS4 extends CRadioMeasParam
{
    public Short mUL_TS4;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMUL_TS4")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mUL_TS4)))
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

            mUL_TS4 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMUL_TS4 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_TS4 = info.mUL_TS4;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_TS4 = null;
    }

    public String ToString()
    {
        if (mUL_TS4 == null)
            return "";
        else
            return String.format("%s", mUL_TS4);
    }

    public String GetTypeName()
    {
        return "Models.CGSMUL_TS4";
    }
}

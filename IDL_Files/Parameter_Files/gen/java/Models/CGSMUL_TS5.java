
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMUL_TS5 extends CRadioMeasParam
{
    public Short mUL_TS5;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMUL_TS5")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mUL_TS5)))
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

            mUL_TS5 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMUL_TS5 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_TS5 = info.mUL_TS5;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_TS5 = null;
    }

    public String ToString()
    {
        if (mUL_TS5 == null)
            return "";
        else
            return String.format("%s", mUL_TS5);
    }

    public String GetTypeName()
    {
        return "Models.CGSMUL_TS5";
    }
}

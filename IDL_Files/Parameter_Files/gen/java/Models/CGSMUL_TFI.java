
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMUL_TFI extends CRadioMeasParam
{
    public Integer mUL_TFI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMUL_TFI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUL_TFI)))
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

            mUL_TFI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMUL_TFI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_TFI = info.mUL_TFI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_TFI = null;
    }

    public String ToString()
    {
        if (mUL_TFI == null)
            return "";
        else
            return String.format("%s", mUL_TFI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMUL_TFI";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCS_UL extends CRadioMeasParam
{
    public Short mCS_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCS_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCS_UL)))
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

            mCS_UL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCS_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCS_UL = info.mCS_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCS_UL = null;
    }

    public String ToString()
    {
        if (mCS_UL == null)
            return "";
        else
            return String.format("%s", mCS_UL);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCS_UL";
    }
}

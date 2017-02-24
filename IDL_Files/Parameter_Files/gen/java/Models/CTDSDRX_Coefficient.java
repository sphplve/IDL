
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDRX_Coefficient extends CRadioMeasParam
{
    public Short mDRX_Coefficient;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDRX_Coefficient")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDRX_Coefficient)))
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

            mDRX_Coefficient = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDRX_Coefficient info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDRX_Coefficient = info.mDRX_Coefficient;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDRX_Coefficient = null;
    }

    public String ToString()
    {
        if (mDRX_Coefficient == null)
            return "";
        else
            return String.format("%s", mDRX_Coefficient);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDRX_Coefficient";
    }
}

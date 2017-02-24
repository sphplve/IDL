
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDL_RLC_ErrorRate extends CRadioMeasParam
{
    public Double mDL_RLC_ErrorRate;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDL_RLC_ErrorRate")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_RLC_ErrorRate)))
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

            mDL_RLC_ErrorRate = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDL_RLC_ErrorRate info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_RLC_ErrorRate = info.mDL_RLC_ErrorRate;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_RLC_ErrorRate = null;
    }

    public String ToString()
    {
        if (mDL_RLC_ErrorRate == null)
            return "";
        else
            return String.format("%s", mDL_RLC_ErrorRate);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDL_RLC_ErrorRate";
    }
}

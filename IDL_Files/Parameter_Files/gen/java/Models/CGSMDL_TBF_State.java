
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_TBF_State extends CRadioMeasParam
{
    public Boolean mDL_TBF_State;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_TBF_State")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean$(mDL_TBF_State)))
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

            mDL_TBF_State = parcel.ReadBoolean$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_TBF_State info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_TBF_State = info.mDL_TBF_State;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_TBF_State = null;
    }

    public String ToString()
    {
        if (mDL_TBF_State == null)
            return "";
        else
            return String.format("%s", mDL_TBF_State);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_TBF_State";
    }
}

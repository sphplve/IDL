
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMPC_Meas_Chan extends CRadioMeasParam
{
    public String mPC_Meas_Chan;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMPC_Meas_Chan")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mPC_Meas_Chan)))
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

            mPC_Meas_Chan = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMPC_Meas_Chan info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPC_Meas_Chan = info.mPC_Meas_Chan;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPC_Meas_Chan = null;
    }

    public String ToString()
    {
        if (mPC_Meas_Chan == null)
            return String.format("");
        else
            return mPC_Meas_Chan;
    }

    public String GetTypeName()
    {
        return "Models.CGSMPC_Meas_Chan";
    }
}

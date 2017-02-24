
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASCC_Disconnect_Cause extends CRadioMeasParam
{
    public Short mCC_Disconnect_Cause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASCC_Disconnect_Cause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCC_Disconnect_Cause)))
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

            mCC_Disconnect_Cause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASCC_Disconnect_Cause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCC_Disconnect_Cause = info.mCC_Disconnect_Cause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCC_Disconnect_Cause = null;
    }

    public String ToString()
    {
        if (mCC_Disconnect_Cause == null)
            return "";
        else
            return String.format("%s", mCC_Disconnect_Cause);
    }

    public String GetTypeName()
    {
        return "Models.CNASCC_Disconnect_Cause";
    }
}

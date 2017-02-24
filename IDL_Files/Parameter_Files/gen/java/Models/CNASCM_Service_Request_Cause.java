
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASCM_Service_Request_Cause extends CRadioMeasParam
{
    public Short mCM_Service_Request_Cause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASCM_Service_Request_Cause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCM_Service_Request_Cause)))
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

            mCM_Service_Request_Cause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASCM_Service_Request_Cause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCM_Service_Request_Cause = info.mCM_Service_Request_Cause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCM_Service_Request_Cause = null;
    }

    public String ToString()
    {
        if (mCM_Service_Request_Cause == null)
            return "";
        else
            return String.format("%s", mCM_Service_Request_Cause);
    }

    public String GetTypeName()
    {
        return "Models.CNASCM_Service_Request_Cause";
    }
}

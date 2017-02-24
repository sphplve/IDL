
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMax_Retransmission extends CRadioMeasParam
{
    public Short mMax_Retransmission;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMax_Retransmission")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMax_Retransmission)))
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

            mMax_Retransmission = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMax_Retransmission info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMax_Retransmission = info.mMax_Retransmission;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMax_Retransmission = null;
    }

    public String ToString()
    {
        if (mMax_Retransmission == null)
            return "";
        else
            return String.format("%s", mMax_Retransmission);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMax_Retransmission";
    }
}

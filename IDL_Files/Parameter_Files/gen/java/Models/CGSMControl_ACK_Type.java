
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMControl_ACK_Type extends CRadioMeasParam
{
    public String mControl_ACK_Type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMControl_ACK_Type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mControl_ACK_Type)))
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

            mControl_ACK_Type = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMControl_ACK_Type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mControl_ACK_Type = info.mControl_ACK_Type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mControl_ACK_Type = null;
    }

    public String ToString()
    {
        if (mControl_ACK_Type == null)
            return String.format("");
        else
            return mControl_ACK_Type;
    }

    public String GetTypeName()
    {
        return "Models.CGSMControl_ACK_Type";
    }
}

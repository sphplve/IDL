
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMNetwork_control_order extends CRadioMeasParam
{
    public Short mNetwork_control_order;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNetwork_control_order")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNetwork_control_order)))
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

            mNetwork_control_order = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNetwork_control_order info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNetwork_control_order = info.mNetwork_control_order;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNetwork_control_order = null;
    }

    public String ToString()
    {
        if (mNetwork_control_order == null)
            return "";
        else
            return String.format("%s", mNetwork_control_order);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNetwork_control_order";
    }
}

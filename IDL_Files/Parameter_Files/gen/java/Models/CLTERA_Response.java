
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERA_Response extends CRadioMeasParam
{
    public Short mRA_Response;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERA_Response")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRA_Response)))
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

            mRA_Response = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERA_Response info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRA_Response = info.mRA_Response;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRA_Response = null;
    }

    public String ToString()
    {
        if (mRA_Response == null)
            return "";
        else
            return String.format("%s", mRA_Response);
    }

    public String GetTypeName()
    {
        return "Models.CLTERA_Response";
    }
}

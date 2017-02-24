
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECP_Type extends CRadioMeasParam
{
    public Short mCP_Type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECP_Type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCP_Type)))
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

            mCP_Type = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECP_Type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCP_Type = info.mCP_Type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCP_Type = null;
    }

    public String ToString()
    {
        if (mCP_Type == null)
            return "";
        else
            return String.format("%s", mCP_Type);
    }

    public String GetTypeName()
    {
        return "Models.CLTECP_Type";
    }
}

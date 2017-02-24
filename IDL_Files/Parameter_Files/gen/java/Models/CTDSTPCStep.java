
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTPCStep extends CRadioMeasParam
{
    public Short mTPCStep;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTPCStep")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTPCStep)))
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

            mTPCStep = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTPCStep info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTPCStep = info.mTPCStep;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTPCStep = null;
    }

    public String ToString()
    {
        if (mTPCStep == null)
            return "";
        else
            return String.format("%s", mTPCStep);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTPCStep";
    }
}

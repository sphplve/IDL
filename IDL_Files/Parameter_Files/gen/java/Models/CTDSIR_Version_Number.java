
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSIR_Version_Number extends CRadioMeasParam
{
    public Short mIR_Version_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSIR_Version_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mIR_Version_Number)))
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

            mIR_Version_Number = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSIR_Version_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIR_Version_Number = info.mIR_Version_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIR_Version_Number = null;
    }

    public String ToString()
    {
        if (mIR_Version_Number == null)
            return "";
        else
            return String.format("%s", mIR_Version_Number);
    }

    public String GetTypeName()
    {
        return "Models.CTDSIR_Version_Number";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEHARQ_Process_Number extends CRadioMeasParam
{
    public Short mHARQ_Process_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEHARQ_Process_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHARQ_Process_Number)))
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

            mHARQ_Process_Number = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEHARQ_Process_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHARQ_Process_Number = info.mHARQ_Process_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHARQ_Process_Number = null;
    }

    public String ToString()
    {
        if (mHARQ_Process_Number == null)
            return "";
        else
            return String.format("%s", mHARQ_Process_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTEHARQ_Process_Number";
    }
}

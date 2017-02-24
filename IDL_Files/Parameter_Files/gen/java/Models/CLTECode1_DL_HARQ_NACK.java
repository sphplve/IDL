
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECode1_DL_HARQ_NACK extends CRadioMeasParam
{
    public Integer mCode1_DL_HARQ_NACK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECode1_DL_HARQ_NACK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCode1_DL_HARQ_NACK)))
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

            mCode1_DL_HARQ_NACK = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECode1_DL_HARQ_NACK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCode1_DL_HARQ_NACK = info.mCode1_DL_HARQ_NACK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCode1_DL_HARQ_NACK = null;
    }

    public String ToString()
    {
        if (mCode1_DL_HARQ_NACK == null)
            return "";
        else
            return String.format("%s", mCode1_DL_HARQ_NACK);
    }

    public String GetTypeName()
    {
        return "Models.CLTECode1_DL_HARQ_NACK";
    }
}

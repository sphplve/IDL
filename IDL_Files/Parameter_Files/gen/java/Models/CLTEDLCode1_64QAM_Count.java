
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode1_64QAM_Count extends CRadioMeasParam
{
    public Long mDLCode1_64QAM_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode1_64QAM_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mDLCode1_64QAM_Count)))
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

            mDLCode1_64QAM_Count = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode1_64QAM_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode1_64QAM_Count = info.mDLCode1_64QAM_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode1_64QAM_Count = null;
    }

    public String ToString()
    {
        if (mDLCode1_64QAM_Count == null)
            return "";
        else
            return String.format("%s", mDLCode1_64QAM_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode1_64QAM_Count";
    }
}

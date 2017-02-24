
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode0_64QAM_Count extends CRadioMeasParam
{
    public Long mDLCode0_64QAM_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode0_64QAM_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mDLCode0_64QAM_Count)))
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

            mDLCode0_64QAM_Count = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode0_64QAM_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode0_64QAM_Count = info.mDLCode0_64QAM_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode0_64QAM_Count = null;
    }

    public String ToString()
    {
        if (mDLCode0_64QAM_Count == null)
            return "";
        else
            return String.format("%s", mDLCode0_64QAM_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode0_64QAM_Count";
    }
}

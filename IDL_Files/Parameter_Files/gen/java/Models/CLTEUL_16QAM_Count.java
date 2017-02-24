
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_16QAM_Count extends CRadioMeasParam
{
    public Long mUL_16QAM_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_16QAM_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mUL_16QAM_Count)))
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

            mUL_16QAM_Count = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_16QAM_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_16QAM_Count = info.mUL_16QAM_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_16QAM_Count = null;
    }

    public String ToString()
    {
        if (mUL_16QAM_Count == null)
            return "";
        else
            return String.format("%s", mUL_16QAM_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_16QAM_Count";
    }
}

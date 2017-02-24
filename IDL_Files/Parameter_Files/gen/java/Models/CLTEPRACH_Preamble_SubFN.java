
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPRACH_Preamble_SubFN extends CRadioMeasParam
{
    public Short mPRACH_Preamble_SubFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPRACH_Preamble_SubFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPRACH_Preamble_SubFN)))
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

            mPRACH_Preamble_SubFN = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPRACH_Preamble_SubFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_Preamble_SubFN = info.mPRACH_Preamble_SubFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_Preamble_SubFN = null;
    }

    public String ToString()
    {
        if (mPRACH_Preamble_SubFN == null)
            return "";
        else
            return String.format("%s", mPRACH_Preamble_SubFN);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPRACH_Preamble_SubFN";
    }
}

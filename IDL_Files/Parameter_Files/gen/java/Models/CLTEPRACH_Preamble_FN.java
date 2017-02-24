
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPRACH_Preamble_FN extends CRadioMeasParam
{
    public Integer mPRACH_Preamble_FN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPRACH_Preamble_FN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPRACH_Preamble_FN)))
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

            mPRACH_Preamble_FN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPRACH_Preamble_FN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_Preamble_FN = info.mPRACH_Preamble_FN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_Preamble_FN = null;
    }

    public String ToString()
    {
        if (mPRACH_Preamble_FN == null)
            return "";
        else
            return String.format("%s", mPRACH_Preamble_FN);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPRACH_Preamble_FN";
    }
}

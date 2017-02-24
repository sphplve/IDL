
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_CCE_Number extends CRadioMeasParam
{
    public Short mPDCCH_CCE_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_CCE_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPDCCH_CCE_Number)))
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

            mPDCCH_CCE_Number = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_CCE_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_CCE_Number = info.mPDCCH_CCE_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_CCE_Number = null;
    }

    public String ToString()
    {
        if (mPDCCH_CCE_Number == null)
            return "";
        else
            return String.format("%s", mPDCCH_CCE_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_CCE_Number";
    }
}

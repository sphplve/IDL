
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCH_RB_Number extends CRadioMeasParam
{
    public Long mPDSCH_RB_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCH_RB_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_RB_Number)))
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

            mPDSCH_RB_Number = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCH_RB_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_RB_Number = info.mPDSCH_RB_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_RB_Number = null;
    }

    public String ToString()
    {
        if (mPDSCH_RB_Number == null)
            return "";
        else
            return String.format("%s", mPDSCH_RB_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCH_RB_Number";
    }
}

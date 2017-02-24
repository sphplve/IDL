
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCH_RB_Number extends CRadioMeasParam
{
    public Long mPUSCH_RB_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCH_RB_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPUSCH_RB_Number)))
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

            mPUSCH_RB_Number = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCH_RB_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCH_RB_Number = info.mPUSCH_RB_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCH_RB_Number = null;
    }

    public String ToString()
    {
        if (mPUSCH_RB_Number == null)
            return "";
        else
            return String.format("%s", mPUSCH_RB_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCH_RB_Number";
    }
}

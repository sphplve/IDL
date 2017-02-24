
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESRS_RB_Number extends CRadioMeasParam
{
    public Long mSRS_RB_Number;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESRS_RB_Number")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mSRS_RB_Number)))
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

            mSRS_RB_Number = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESRS_RB_Number info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSRS_RB_Number = info.mSRS_RB_Number;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSRS_RB_Number = null;
    }

    public String ToString()
    {
        if (mSRS_RB_Number == null)
            return "";
        else
            return String.format("%s", mSRS_RB_Number);
    }

    public String GetTypeName()
    {
        return "Models.CLTESRS_RB_Number";
    }
}

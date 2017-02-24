
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCH_TB_Size_Code1 extends CRadioMeasParam
{
    public Long mPDSCH_TB_Size_Code1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCH_TB_Size_Code1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_TB_Size_Code1)))
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

            mPDSCH_TB_Size_Code1 = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCH_TB_Size_Code1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_TB_Size_Code1 = info.mPDSCH_TB_Size_Code1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_TB_Size_Code1 = null;
    }

    public String ToString()
    {
        if (mPDSCH_TB_Size_Code1 == null)
            return "";
        else
            return String.format("%s", mPDSCH_TB_Size_Code1);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCH_TB_Size_Code1";
    }
}

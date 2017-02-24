
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_Modulation_Code1 extends CRadioMeasParam
{
    public Short mDL_Modulation_Code1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_Modulation_Code1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDL_Modulation_Code1)))
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

            mDL_Modulation_Code1 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_Modulation_Code1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_Modulation_Code1 = info.mDL_Modulation_Code1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_Modulation_Code1 = null;
    }

    public String ToString()
    {
        if (mDL_Modulation_Code1 == null)
            return "";
        else
            return String.format("%s", mDL_Modulation_Code1);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_Modulation_Code1";
    }
}

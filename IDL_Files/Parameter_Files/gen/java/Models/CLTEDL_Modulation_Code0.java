
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_Modulation_Code0 extends CRadioMeasParam
{
    public Short mDL_Modulation_Code0;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_Modulation_Code0")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDL_Modulation_Code0)))
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

            mDL_Modulation_Code0 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_Modulation_Code0 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_Modulation_Code0 = info.mDL_Modulation_Code0;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_Modulation_Code0 = null;
    }

    public String ToString()
    {
        if (mDL_Modulation_Code0 == null)
            return "";
        else
            return String.format("%s", mDL_Modulation_Code0);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_Modulation_Code0";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTS_Number_DL extends CRadioMeasParam
{
    public Short mTS_Number_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTS_Number_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTS_Number_DL)))
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

            mTS_Number_DL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTS_Number_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS_Number_DL = info.mTS_Number_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS_Number_DL = null;
    }

    public String ToString()
    {
        if (mTS_Number_DL == null)
            return "";
        else
            return String.format("%s", mTS_Number_DL);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTS_Number_DL";
    }
}

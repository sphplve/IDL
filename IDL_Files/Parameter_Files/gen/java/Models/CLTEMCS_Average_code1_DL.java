
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMCS_Average_code1_DL extends CRadioMeasParam
{
    public Short mMCS_Average_code1_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMCS_Average_code1_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMCS_Average_code1_DL)))
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

            mMCS_Average_code1_DL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMCS_Average_code1_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMCS_Average_code1_DL = info.mMCS_Average_code1_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMCS_Average_code1_DL = null;
    }

    public String ToString()
    {
        if (mMCS_Average_code1_DL == null)
            return "";
        else
            return String.format("%s", mMCS_Average_code1_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMCS_Average_code1_DL";
    }
}

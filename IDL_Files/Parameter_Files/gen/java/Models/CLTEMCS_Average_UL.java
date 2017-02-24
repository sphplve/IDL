
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMCS_Average_UL extends CRadioMeasParam
{
    public Short mMCS_Average_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMCS_Average_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMCS_Average_UL)))
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

            mMCS_Average_UL = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMCS_Average_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMCS_Average_UL = info.mMCS_Average_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMCS_Average_UL = null;
    }

    public String ToString()
    {
        if (mMCS_Average_UL == null)
            return "";
        else
            return String.format("%s", mMCS_Average_UL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMCS_Average_UL";
    }
}

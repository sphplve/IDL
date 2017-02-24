
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_Rhychn_ID extends CRadioMeasParam
{
    public Short mPRACH_Rhychn_ID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_Rhychn_ID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPRACH_Rhychn_ID)))
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

            mPRACH_Rhychn_ID = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_Rhychn_ID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_Rhychn_ID = info.mPRACH_Rhychn_ID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_Rhychn_ID = null;
    }

    public String ToString()
    {
        if (mPRACH_Rhychn_ID == null)
            return "";
        else
            return String.format("%s", mPRACH_Rhychn_ID);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_Rhychn_ID";
    }
}

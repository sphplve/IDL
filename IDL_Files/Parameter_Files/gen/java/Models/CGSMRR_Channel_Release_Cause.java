
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRR_Channel_Release_Cause extends CRadioMeasParam
{
    public Short mRR_Channel_Release_Cause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRR_Channel_Release_Cause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRR_Channel_Release_Cause)))
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

            mRR_Channel_Release_Cause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRR_Channel_Release_Cause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRR_Channel_Release_Cause = info.mRR_Channel_Release_Cause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRR_Channel_Release_Cause = null;
    }

    public String ToString()
    {
        if (mRR_Channel_Release_Cause == null)
            return "";
        else
            return String.format("%s", mRR_Channel_Release_Cause);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRR_Channel_Release_Cause";
    }
}

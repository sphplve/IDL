
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSRRC_Connection_Release_DL_DCCH_Cause extends CRadioMeasParam
{
    public Short mRRC_Connection_Release_DL_DCCH_Cause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRRC_Connection_Release_DL_DCCH_Cause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRRC_Connection_Release_DL_DCCH_Cause)))
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

            mRRC_Connection_Release_DL_DCCH_Cause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRRC_Connection_Release_DL_DCCH_Cause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRRC_Connection_Release_DL_DCCH_Cause = info.mRRC_Connection_Release_DL_DCCH_Cause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRRC_Connection_Release_DL_DCCH_Cause = null;
    }

    public String ToString()
    {
        if (mRRC_Connection_Release_DL_DCCH_Cause == null)
            return "";
        else
            return String.format("%s", mRRC_Connection_Release_DL_DCCH_Cause);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRRC_Connection_Release_DL_DCCH_Cause";
    }
}

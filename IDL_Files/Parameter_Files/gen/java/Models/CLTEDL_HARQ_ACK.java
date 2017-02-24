
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_HARQ_ACK extends CRadioMeasParam
{
    public Integer mDL_HARQ_ACK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_HARQ_ACK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDL_HARQ_ACK)))
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

            mDL_HARQ_ACK = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_HARQ_ACK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_HARQ_ACK = info.mDL_HARQ_ACK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_HARQ_ACK = null;
    }

    public String ToString()
    {
        if (mDL_HARQ_ACK == null)
            return "";
        else
            return String.format("%s", mDL_HARQ_ACK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_HARQ_ACK";
    }
}

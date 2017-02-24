
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_HARQ_NACK extends CRadioMeasParam
{
    public Integer mDL_HARQ_NACK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_HARQ_NACK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDL_HARQ_NACK)))
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

            mDL_HARQ_NACK = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_HARQ_NACK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_HARQ_NACK = info.mDL_HARQ_NACK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_HARQ_NACK = null;
    }

    public String ToString()
    {
        if (mDL_HARQ_NACK == null)
            return "";
        else
            return String.format("%s", mDL_HARQ_NACK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_HARQ_NACK";
    }
}

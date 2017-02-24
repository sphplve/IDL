
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCH_ACK_Count extends CRadioMeasParam
{
    public Integer mPUSCH_ACK_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCH_ACK_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPUSCH_ACK_Count)))
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

            mPUSCH_ACK_Count = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCH_ACK_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCH_ACK_Count = info.mPUSCH_ACK_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCH_ACK_Count = null;
    }

    public String ToString()
    {
        if (mPUSCH_ACK_Count == null)
            return "";
        else
            return String.format("%s", mPUSCH_ACK_Count);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCH_ACK_Count";
    }
}

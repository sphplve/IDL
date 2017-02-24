
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEQ_OffsetFreq extends CRadioMeasParam
{
    public Integer mQ_OffsetFreq;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEQ_OffsetFreq")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mQ_OffsetFreq)))
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

            mQ_OffsetFreq = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEQ_OffsetFreq info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQ_OffsetFreq = info.mQ_OffsetFreq;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQ_OffsetFreq = null;
    }

    public String ToString()
    {
        if (mQ_OffsetFreq == null)
            return "";
        else
            return String.format("%s", mQ_OffsetFreq);
    }

    public String GetTypeName()
    {
        return "Models.CLTEQ_OffsetFreq";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERSRQ extends CRadioMeasParam
{
    public Double mRSRQ;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERSRQ")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRSRQ)))
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

            mRSRQ = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERSRQ info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRSRQ = info.mRSRQ;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRSRQ = null;
    }

    public String ToString()
    {
        if (mRSRQ == null)
            return "";
        else
            return String.format("%s", mRSRQ);
    }

    public String GetTypeName()
    {
        return "Models.CLTERSRQ";
    }
}

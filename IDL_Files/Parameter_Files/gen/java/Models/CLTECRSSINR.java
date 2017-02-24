
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECRSSINR extends CRadioMeasParam
{
    public Double mCRSSINR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECRSSINR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mCRSSINR)))
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

            mCRSSINR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECRSSINR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCRSSINR = info.mCRSSINR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCRSSINR = null;
    }

    public String ToString()
    {
        if (mCRSSINR == null)
            return "";
        else
            return String.format("%s", mCRSSINR);
    }

    public String GetTypeName()
    {
        return "Models.CLTECRSSINR";
    }
}

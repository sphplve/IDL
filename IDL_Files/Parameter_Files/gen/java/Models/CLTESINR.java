
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESINR extends CRadioMeasParam
{
    public Double mSINR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESINR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSINR)))
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

            mSINR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESINR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSINR = info.mSINR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSINR = null;
    }

    public String ToString()
    {
        if (mSINR == null)
            return "";
        else
            return String.format("%s", mSINR);
    }

    public String GetTypeName()
    {
        return "Models.CLTESINR";
    }
}

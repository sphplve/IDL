
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERankIndicator extends CRadioMeasParam
{
    public String mRankIndicator;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERankIndicator")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRankIndicator)))
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

            mRankIndicator = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERankIndicator info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRankIndicator = info.mRankIndicator;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRankIndicator = null;
    }

    public String ToString()
    {
        if (mRankIndicator == null)
            return String.format("");
        else
            return mRankIndicator;
    }

    public String GetTypeName()
    {
        return "Models.CLTERankIndicator";
    }
}

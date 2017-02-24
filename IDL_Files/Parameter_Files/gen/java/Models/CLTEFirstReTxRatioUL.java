
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstReTxRatioUL extends CRadioMeasParam
{
    public Double mFirstReTxRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstReTxRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFirstReTxRatioUL)))
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

            mFirstReTxRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstReTxRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstReTxRatioUL = info.mFirstReTxRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstReTxRatioUL = null;
    }

    public String ToString()
    {
        if (mFirstReTxRatioUL == null)
            return "";
        else
            return String.format("%s", mFirstReTxRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstReTxRatioUL";
    }
}

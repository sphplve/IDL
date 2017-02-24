
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstTransferRatioUL extends CRadioMeasParam
{
    public Double mFirstTransferRatioUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstTransferRatioUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFirstTransferRatioUL)))
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

            mFirstTransferRatioUL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstTransferRatioUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstTransferRatioUL = info.mFirstTransferRatioUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstTransferRatioUL = null;
    }

    public String ToString()
    {
        if (mFirstTransferRatioUL == null)
            return "";
        else
            return String.format("%s", mFirstTransferRatioUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstTransferRatioUL";
    }
}

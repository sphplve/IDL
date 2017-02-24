
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstTransferRatioDL extends CRadioMeasParam
{
    public Double mFirstTransferRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstTransferRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFirstTransferRatioDL)))
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

            mFirstTransferRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstTransferRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstTransferRatioDL = info.mFirstTransferRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstTransferRatioDL = null;
    }

    public String ToString()
    {
        if (mFirstTransferRatioDL == null)
            return "";
        else
            return String.format("%s", mFirstTransferRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstTransferRatioDL";
    }
}

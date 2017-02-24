
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstReTxRatioDL extends CRadioMeasParam
{
    public Double mFirstReTxRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstReTxRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFirstReTxRatioDL)))
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

            mFirstReTxRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstReTxRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstReTxRatioDL = info.mFirstReTxRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstReTxRatioDL = null;
    }

    public String ToString()
    {
        if (mFirstReTxRatioDL == null)
            return "";
        else
            return String.format("%s", mFirstReTxRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstReTxRatioDL";
    }
}

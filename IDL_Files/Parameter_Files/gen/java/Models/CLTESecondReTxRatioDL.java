
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTxRatioDL extends CRadioMeasParam
{
    public Double mSecondReTxRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTxRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSecondReTxRatioDL)))
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

            mSecondReTxRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTxRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTxRatioDL = info.mSecondReTxRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTxRatioDL = null;
    }

    public String ToString()
    {
        if (mSecondReTxRatioDL == null)
            return "";
        else
            return String.format("%s", mSecondReTxRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTxRatioDL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFourthReTxRatioDL extends CRadioMeasParam
{
    public Double mFourthReTxRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFourthReTxRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mFourthReTxRatioDL)))
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

            mFourthReTxRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFourthReTxRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFourthReTxRatioDL = info.mFourthReTxRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFourthReTxRatioDL = null;
    }

    public String ToString()
    {
        if (mFourthReTxRatioDL == null)
            return "";
        else
            return String.format("%s", mFourthReTxRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFourthReTxRatioDL";
    }
}

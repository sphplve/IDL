
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEReTxFailureRatioDL extends CRadioMeasParam
{
    public Double mReTxFailureRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEReTxFailureRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mReTxFailureRatioDL)))
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

            mReTxFailureRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEReTxFailureRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReTxFailureRatioDL = info.mReTxFailureRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReTxFailureRatioDL = null;
    }

    public String ToString()
    {
        if (mReTxFailureRatioDL == null)
            return "";
        else
            return String.format("%s", mReTxFailureRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEReTxFailureRatioDL";
    }
}

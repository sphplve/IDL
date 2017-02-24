
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEReTxFailureUL extends CRadioMeasParam
{
    public Integer mReTxFailureUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEReTxFailureUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mReTxFailureUL)))
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

            mReTxFailureUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEReTxFailureUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReTxFailureUL = info.mReTxFailureUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReTxFailureUL = null;
    }

    public String ToString()
    {
        if (mReTxFailureUL == null)
            return "";
        else
            return String.format("%s", mReTxFailureUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEReTxFailureUL";
    }
}

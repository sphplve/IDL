
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEReTxFailureDL extends CRadioMeasParam
{
    public Integer mReTxFailureDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEReTxFailureDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mReTxFailureDL)))
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

            mReTxFailureDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEReTxFailureDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReTxFailureDL = info.mReTxFailureDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReTxFailureDL = null;
    }

    public String ToString()
    {
        if (mReTxFailureDL == null)
            return "";
        else
            return String.format("%s", mReTxFailureDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEReTxFailureDL";
    }
}

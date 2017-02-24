
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEReTxFailure_code0_DL extends CRadioMeasParam
{
    public Integer mReTxFailure_code0_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEReTxFailure_code0_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mReTxFailure_code0_DL)))
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

            mReTxFailure_code0_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEReTxFailure_code0_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReTxFailure_code0_DL = info.mReTxFailure_code0_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReTxFailure_code0_DL = null;
    }

    public String ToString()
    {
        if (mReTxFailure_code0_DL == null)
            return "";
        else
            return String.format("%s", mReTxFailure_code0_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEReTxFailure_code0_DL";
    }
}

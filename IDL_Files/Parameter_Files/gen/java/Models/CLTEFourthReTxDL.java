
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFourthReTxDL extends CRadioMeasParam
{
    public Integer mFourthReTxDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFourthReTxDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFourthReTxDL)))
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

            mFourthReTxDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFourthReTxDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFourthReTxDL = info.mFourthReTxDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFourthReTxDL = null;
    }

    public String ToString()
    {
        if (mFourthReTxDL == null)
            return "";
        else
            return String.format("%s", mFourthReTxDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFourthReTxDL";
    }
}

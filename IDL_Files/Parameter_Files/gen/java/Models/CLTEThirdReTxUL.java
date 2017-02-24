
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTxUL extends CRadioMeasParam
{
    public Integer mThirdReTxUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTxUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThirdReTxUL)))
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

            mThirdReTxUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTxUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTxUL = info.mThirdReTxUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTxUL = null;
    }

    public String ToString()
    {
        if (mThirdReTxUL == null)
            return "";
        else
            return String.format("%s", mThirdReTxUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTxUL";
    }
}

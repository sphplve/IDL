
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTxUL extends CRadioMeasParam
{
    public Integer mSecondReTxUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTxUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSecondReTxUL)))
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

            mSecondReTxUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTxUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTxUL = info.mSecondReTxUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTxUL = null;
    }

    public String ToString()
    {
        if (mSecondReTxUL == null)
            return "";
        else
            return String.format("%s", mSecondReTxUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTxUL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTxDL extends CRadioMeasParam
{
    public Integer mSecondReTxDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTxDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSecondReTxDL)))
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

            mSecondReTxDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTxDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTxDL = info.mSecondReTxDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTxDL = null;
    }

    public String ToString()
    {
        if (mSecondReTxDL == null)
            return "";
        else
            return String.format("%s", mSecondReTxDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTxDL";
    }
}

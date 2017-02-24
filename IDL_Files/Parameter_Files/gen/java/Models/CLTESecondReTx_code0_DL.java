
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESecondReTx_code0_DL extends CRadioMeasParam
{
    public Integer mSecondReTx_code0_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESecondReTx_code0_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSecondReTx_code0_DL)))
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

            mSecondReTx_code0_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESecondReTx_code0_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSecondReTx_code0_DL = info.mSecondReTx_code0_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSecondReTx_code0_DL = null;
    }

    public String ToString()
    {
        if (mSecondReTx_code0_DL == null)
            return "";
        else
            return String.format("%s", mSecondReTx_code0_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTESecondReTx_code0_DL";
    }
}

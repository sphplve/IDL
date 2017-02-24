
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTxDL extends CRadioMeasParam
{
    public Integer mThirdReTxDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTxDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mThirdReTxDL)))
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

            mThirdReTxDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTxDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTxDL = info.mThirdReTxDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTxDL = null;
    }

    public String ToString()
    {
        if (mThirdReTxDL == null)
            return "";
        else
            return String.format("%s", mThirdReTxDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTxDL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEThirdReTxRatioDL extends CRadioMeasParam
{
    public Double mThirdReTxRatioDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEThirdReTxRatioDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mThirdReTxRatioDL)))
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

            mThirdReTxRatioDL = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEThirdReTxRatioDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mThirdReTxRatioDL = info.mThirdReTxRatioDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mThirdReTxRatioDL = null;
    }

    public String ToString()
    {
        if (mThirdReTxRatioDL == null)
            return "";
        else
            return String.format("%s", mThirdReTxRatioDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEThirdReTxRatioDL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEEARFCN_UL extends CRadioMeasParam
{
    public Integer mEARFCN_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEEARFCN_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mEARFCN_UL)))
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

            mEARFCN_UL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEEARFCN_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEARFCN_UL = info.mEARFCN_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEARFCN_UL = null;
    }

    public String ToString()
    {
        if (mEARFCN_UL == null)
            return "";
        else
            return String.format("%s", mEARFCN_UL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEEARFCN_UL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEEARFCN_DL extends CRadioMeasParam
{
    public Integer mEARFCN_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEEARFCN_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mEARFCN_DL)))
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

            mEARFCN_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEEARFCN_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEARFCN_DL = info.mEARFCN_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEARFCN_DL = null;
    }

    public String ToString()
    {
        if (mEARFCN_DL == null)
            return "";
        else
            return String.format("%s", mEARFCN_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEEARFCN_DL";
    }
}

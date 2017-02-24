
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_QPSK extends CRadioMeasParam
{
    public Double mUL_QPSK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_QPSK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_QPSK)))
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

            mUL_QPSK = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_QPSK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_QPSK = info.mUL_QPSK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_QPSK = null;
    }

    public String ToString()
    {
        if (mUL_QPSK == null)
            return "";
        else
            return String.format("%s", mUL_QPSK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_QPSK";
    }
}

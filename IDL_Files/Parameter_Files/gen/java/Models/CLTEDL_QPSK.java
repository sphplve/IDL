
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_QPSK extends CRadioMeasParam
{
    public Double mDL_QPSK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_QPSK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_QPSK)))
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

            mDL_QPSK = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_QPSK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_QPSK = info.mDL_QPSK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_QPSK = null;
    }

    public String ToString()
    {
        if (mDL_QPSK == null)
            return "";
        else
            return String.format("%s", mDL_QPSK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_QPSK";
    }
}

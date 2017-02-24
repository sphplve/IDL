
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode0_QPSK extends CRadioMeasParam
{
    public Double mDLCode0_QPSK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode0_QPSK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDLCode0_QPSK)))
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

            mDLCode0_QPSK = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode0_QPSK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode0_QPSK = info.mDLCode0_QPSK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode0_QPSK = null;
    }

    public String ToString()
    {
        if (mDLCode0_QPSK == null)
            return "";
        else
            return String.format("%s", mDLCode0_QPSK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode0_QPSK";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode1_QPSK extends CRadioMeasParam
{
    public Double mDLCode1_QPSK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode1_QPSK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDLCode1_QPSK)))
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

            mDLCode1_QPSK = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode1_QPSK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode1_QPSK = info.mDLCode1_QPSK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode1_QPSK = null;
    }

    public String ToString()
    {
        if (mDLCode1_QPSK == null)
            return "";
        else
            return String.format("%s", mDLCode1_QPSK);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode1_QPSK";
    }
}

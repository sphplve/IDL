
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEIntraFreqReselection extends CRadioMeasParam
{
    public String mIntraFreqReselection;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEIntraFreqReselection")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mIntraFreqReselection)))
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

            mIntraFreqReselection = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEIntraFreqReselection info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIntraFreqReselection = info.mIntraFreqReselection;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIntraFreqReselection = null;
    }

    public String ToString()
    {
        if (mIntraFreqReselection == null)
            return String.format("");
        else
            return mIntraFreqReselection;
    }

    public String GetTypeName()
    {
        return "Models.CLTEIntraFreqReselection";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMPeak_Throughput extends CRadioMeasParam
{
    public Short mPeak_Throughput;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMPeak_Throughput")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPeak_Throughput)))
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

            mPeak_Throughput = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMPeak_Throughput info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPeak_Throughput = info.mPeak_Throughput;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPeak_Throughput = null;
    }

    public String ToString()
    {
        if (mPeak_Throughput == null)
            return "";
        else
            return String.format("%s", mPeak_Throughput);
    }

    public String GetTypeName()
    {
        return "Models.CGSMPeak_Throughput";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTS0_DL_RLC_Throughput extends CRadioMeasParam
{
    public Double mTS0_DL_RLC_Throughput;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTS0_DL_RLC_Throughput")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS0_DL_RLC_Throughput)))
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

            mTS0_DL_RLC_Throughput = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTS0_DL_RLC_Throughput info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS0_DL_RLC_Throughput = info.mTS0_DL_RLC_Throughput;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS0_DL_RLC_Throughput = null;
    }

    public String ToString()
    {
        if (mTS0_DL_RLC_Throughput == null)
            return "";
        else
            return String.format("%s", mTS0_DL_RLC_Throughput);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTS0_DL_RLC_Throughput";
    }
}

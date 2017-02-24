
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTS7_DL_RLC_Throughput extends CRadioMeasParam
{
    public Double mTS7_DL_RLC_Throughput;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTS7_DL_RLC_Throughput")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS7_DL_RLC_Throughput)))
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

            mTS7_DL_RLC_Throughput = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTS7_DL_RLC_Throughput info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS7_DL_RLC_Throughput = info.mTS7_DL_RLC_Throughput;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS7_DL_RLC_Throughput = null;
    }

    public String ToString()
    {
        if (mTS7_DL_RLC_Throughput == null)
            return "";
        else
            return String.format("%s", mTS7_DL_RLC_Throughput);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTS7_DL_RLC_Throughput";
    }
}

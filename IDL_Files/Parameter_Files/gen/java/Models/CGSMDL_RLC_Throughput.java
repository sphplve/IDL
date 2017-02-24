
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_RLC_Throughput extends CRadioMeasParam
{
    public Double mDL_RLC_Throughput;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_RLC_Throughput")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_RLC_Throughput)))
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

            mDL_RLC_Throughput = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_RLC_Throughput info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_RLC_Throughput = info.mDL_RLC_Throughput;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_RLC_Throughput = null;
    }

    public String ToString()
    {
        if (mDL_RLC_Throughput == null)
            return "";
        else
            return String.format("%s", mDL_RLC_Throughput);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_RLC_Throughput";
    }
}

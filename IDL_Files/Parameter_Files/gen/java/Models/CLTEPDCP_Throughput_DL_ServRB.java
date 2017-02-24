
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCP_Throughput_DL_ServRB extends CRadioMeasParam
{
    public Double mPDCP_Throughput_DL_ServRB;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCP_Throughput_DL_ServRB")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPDCP_Throughput_DL_ServRB)))
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

            mPDCP_Throughput_DL_ServRB = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCP_Throughput_DL_ServRB info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCP_Throughput_DL_ServRB = info.mPDCP_Throughput_DL_ServRB;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCP_Throughput_DL_ServRB = null;
    }

    public String ToString()
    {
        if (mPDCP_Throughput_DL_ServRB == null)
            return "";
        else
            return String.format("%s", mPDCP_Throughput_DL_ServRB);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCP_Throughput_DL_ServRB";
    }
}

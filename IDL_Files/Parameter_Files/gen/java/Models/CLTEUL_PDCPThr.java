
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_PDCPThr extends CRadioMeasParam
{
    public Double mUL_PDCPThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_PDCPThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_PDCPThr)))
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

            mUL_PDCPThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_PDCPThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_PDCPThr = info.mUL_PDCPThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_PDCPThr = null;
    }

    public String ToString()
    {
        if (mUL_PDCPThr == null)
            return "";
        else
            return String.format("%s", mUL_PDCPThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_PDCPThr";
    }
}

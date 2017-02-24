
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_MACThr extends CRadioMeasParam
{
    public Double mUL_MACThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_MACThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_MACThr)))
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

            mUL_MACThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_MACThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_MACThr = info.mUL_MACThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_MACThr = null;
    }

    public String ToString()
    {
        if (mUL_MACThr == null)
            return "";
        else
            return String.format("%s", mUL_MACThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_MACThr";
    }
}

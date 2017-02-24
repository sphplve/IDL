
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_RLCThr extends CRadioMeasParam
{
    public Double mUL_RLCThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_RLCThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_RLCThr)))
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

            mUL_RLCThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_RLCThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_RLCThr = info.mUL_RLCThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_RLCThr = null;
    }

    public String ToString()
    {
        if (mUL_RLCThr == null)
            return "";
        else
            return String.format("%s", mUL_RLCThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_RLCThr";
    }
}

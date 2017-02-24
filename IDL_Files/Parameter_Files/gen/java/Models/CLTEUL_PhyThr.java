
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_PhyThr extends CRadioMeasParam
{
    public Double mUL_PhyThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_PhyThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mUL_PhyThr)))
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

            mUL_PhyThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_PhyThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUL_PhyThr = info.mUL_PhyThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUL_PhyThr = null;
    }

    public String ToString()
    {
        if (mUL_PhyThr == null)
            return "";
        else
            return String.format("%s", mUL_PhyThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_PhyThr";
    }
}

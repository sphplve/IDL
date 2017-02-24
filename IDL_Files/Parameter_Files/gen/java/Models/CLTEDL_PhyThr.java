
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_PhyThr extends CRadioMeasParam
{
    public Double mDL_PhyThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_PhyThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_PhyThr)))
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

            mDL_PhyThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_PhyThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_PhyThr = info.mDL_PhyThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_PhyThr = null;
    }

    public String ToString()
    {
        if (mDL_PhyThr == null)
            return "";
        else
            return String.format("%s", mDL_PhyThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_PhyThr";
    }
}

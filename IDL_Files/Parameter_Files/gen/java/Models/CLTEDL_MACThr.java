
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_MACThr extends CRadioMeasParam
{
    public Double mDL_MACThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_MACThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_MACThr)))
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

            mDL_MACThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_MACThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_MACThr = info.mDL_MACThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_MACThr = null;
    }

    public String ToString()
    {
        if (mDL_MACThr == null)
            return "";
        else
            return String.format("%s", mDL_MACThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_MACThr";
    }
}

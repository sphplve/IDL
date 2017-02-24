
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_RLCThr extends CRadioMeasParam
{
    public Double mDL_RLCThr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_RLCThr")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_RLCThr)))
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

            mDL_RLCThr = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_RLCThr info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_RLCThr = info.mDL_RLCThr;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_RLCThr = null;
    }

    public String ToString()
    {
        if (mDL_RLCThr == null)
            return "";
        else
            return String.format("%s", mDL_RLCThr);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_RLCThr";
    }
}

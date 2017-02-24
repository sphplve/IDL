
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_PhyThrCode0 extends CRadioMeasParam
{
    public Double mDL_PhyThrCode0;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_PhyThrCode0")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_PhyThrCode0)))
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

            mDL_PhyThrCode0 = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_PhyThrCode0 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_PhyThrCode0 = info.mDL_PhyThrCode0;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_PhyThrCode0 = null;
    }

    public String ToString()
    {
        if (mDL_PhyThrCode0 == null)
            return "";
        else
            return String.format("%s", mDL_PhyThrCode0);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_PhyThrCode0";
    }
}

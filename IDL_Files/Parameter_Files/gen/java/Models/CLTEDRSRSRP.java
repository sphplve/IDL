
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDRSRSRP extends CRadioMeasParam
{
    public Double mDRSRSRP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDRSRSRP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDRSRSRP)))
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

            mDRSRSRP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDRSRSRP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDRSRSRP = info.mDRSRSRP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDRSRSRP = null;
    }

    public String ToString()
    {
        if (mDRSRSRP == null)
            return "";
        else
            return String.format("%s", mDRSRSRP);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDRSRSRP";
    }
}

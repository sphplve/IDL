
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMGMSK_MEAN_BEP extends CRadioMeasParam
{
    public Integer mGMSK_MEAN_BEP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMGMSK_MEAN_BEP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mGMSK_MEAN_BEP)))
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

            mGMSK_MEAN_BEP = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMGMSK_MEAN_BEP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGMSK_MEAN_BEP = info.mGMSK_MEAN_BEP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGMSK_MEAN_BEP = null;
    }

    public String ToString()
    {
        if (mGMSK_MEAN_BEP == null)
            return "";
        else
            return String.format("%s", mGMSK_MEAN_BEP);
    }

    public String GetTypeName()
    {
        return "Models.CGSMGMSK_MEAN_BEP";
    }
}

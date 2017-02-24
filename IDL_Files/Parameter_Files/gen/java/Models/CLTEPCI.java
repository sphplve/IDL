
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPCI extends CRadioMeasParam
{
    public Integer mPCI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPCI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPCI)))
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

            mPCI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPCI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPCI = info.mPCI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPCI = null;
    }

    public String ToString()
    {
        if (mPCI == null)
            return "";
        else
            return String.format("%s", mPCI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPCI";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEECI extends CRadioMeasParam
{
    public Long mECI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEECI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mECI)))
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

            mECI = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEECI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mECI = info.mECI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mECI = null;
    }

    public String ToString()
    {
        if (mECI == null)
            return "";
        else
            return String.format("%s", mECI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEECI";
    }
}

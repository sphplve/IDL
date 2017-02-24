
package Models;

import java.math.BigInteger;
import AXP.CParcel;
import AXP.AResult;

public class CGSMP_TMSI extends CRadioMeasParam
{
    public BigInteger mP_TMSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMP_TMSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mP_TMSI)))
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

            mP_TMSI = parcel.ReadUInt64$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMP_TMSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mP_TMSI = info.mP_TMSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mP_TMSI = null;
    }

    public String ToString()
    {
        if (mP_TMSI == null)
            return "";
        else
            return String.format("%s", mP_TMSI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMP_TMSI";
    }
}

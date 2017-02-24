
package Models;

import java.math.BigInteger;
import AXP.CParcel;
import AXP.AResult;

public class CGSMIMEI extends CRadioMeasParam
{
    public BigInteger mIMEI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMIMEI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mIMEI)))
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

            mIMEI = parcel.ReadUInt64$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMIMEI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIMEI = info.mIMEI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIMEI = null;
    }

    public String ToString()
    {
        if (mIMEI == null)
            return "";
        else
            return String.format("%s", mIMEI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMIMEI";
    }
}

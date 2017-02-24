
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEIMSI extends CRadioMeasParam
{
    public Integer mIMSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEIMSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mIMSI)))
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

            mIMSI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEIMSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIMSI = info.mIMSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIMSI = null;
    }

    public String ToString()
    {
        if (mIMSI == null)
            return "";
        else
            return String.format("%s", mIMSI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEIMSI";
    }
}

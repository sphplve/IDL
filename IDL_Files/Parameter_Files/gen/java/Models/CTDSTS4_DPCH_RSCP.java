
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTS4_DPCH_RSCP extends CRadioMeasParam
{
    public Double mTS4_DPCH_RSCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTS4_DPCH_RSCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mTS4_DPCH_RSCP)))
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

            mTS4_DPCH_RSCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTS4_DPCH_RSCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTS4_DPCH_RSCP = info.mTS4_DPCH_RSCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTS4_DPCH_RSCP = null;
    }

    public String ToString()
    {
        if (mTS4_DPCH_RSCP == null)
            return "";
        else
            return String.format("%s", mTS4_DPCH_RSCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTS4_DPCH_RSCP";
    }
}

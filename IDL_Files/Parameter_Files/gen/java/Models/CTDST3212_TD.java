
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDST3212_TD extends CRadioMeasParam
{
    public Short mT3212_TD;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDST3212_TD")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mT3212_TD)))
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

            mT3212_TD = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDST3212_TD info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mT3212_TD = info.mT3212_TD;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mT3212_TD = null;
    }

    public String ToString()
    {
        if (mT3212_TD == null)
            return "";
        else
            return String.format("%s", mT3212_TD);
    }

    public String GetTypeName()
    {
        return "Models.CTDST3212_TD";
    }
}

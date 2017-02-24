
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUARFCN extends CRadioMeasParam
{
    public Integer mUARFCN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUARFCN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUARFCN)))
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

            mUARFCN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUARFCN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUARFCN = info.mUARFCN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUARFCN = null;
    }

    public String ToString()
    {
        if (mUARFCN == null)
            return "";
        else
            return String.format("%s", mUARFCN);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUARFCN";
    }
}

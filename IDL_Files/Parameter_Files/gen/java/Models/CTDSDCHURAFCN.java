
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSDCHURAFCN extends CRadioMeasParam
{
    public Integer mDCHURAFCN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDCHURAFCN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDCHURAFCN)))
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

            mDCHURAFCN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDCHURAFCN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDCHURAFCN = info.mDCHURAFCN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDCHURAFCN = null;
    }

    public String ToString()
    {
        if (mDCHURAFCN == null)
            return "";
        else
            return String.format("%s", mDCHURAFCN);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDCHURAFCN";
    }
}

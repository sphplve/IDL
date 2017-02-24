
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMEDGE_WinSize_UL extends CRadioMeasParam
{
    public Long mEDGE_WinSize_UL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMEDGE_WinSize_UL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mEDGE_WinSize_UL)))
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

            mEDGE_WinSize_UL = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMEDGE_WinSize_UL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mEDGE_WinSize_UL = info.mEDGE_WinSize_UL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mEDGE_WinSize_UL = null;
    }

    public String ToString()
    {
        if (mEDGE_WinSize_UL == null)
            return "";
        else
            return String.format("%s", mEDGE_WinSize_UL);
    }

    public String GetTypeName()
    {
        return "Models.CGSMEDGE_WinSize_UL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_TFI extends CRadioMeasParam
{
    public Integer mDL_TFI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_TFI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDL_TFI)))
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

            mDL_TFI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_TFI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_TFI = info.mDL_TFI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_TFI = null;
    }

    public String ToString()
    {
        if (mDL_TFI == null)
            return "";
        else
            return String.format("%s", mDL_TFI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_TFI";
    }
}

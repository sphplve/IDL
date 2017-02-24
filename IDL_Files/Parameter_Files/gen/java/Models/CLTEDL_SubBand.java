
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_SubBand extends CRadioMeasParam
{
    public Short mDL_SubBand;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_SubBand")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDL_SubBand)))
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

            mDL_SubBand = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_SubBand info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_SubBand = info.mDL_SubBand;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_SubBand = null;
    }

    public String ToString()
    {
        if (mDL_SubBand == null)
            return "";
        else
            return String.format("%s", mDL_SubBand);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_SubBand";
    }
}

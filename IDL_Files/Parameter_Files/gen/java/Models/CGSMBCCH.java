
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMBCCH extends CRadioMeasParam
{
    public Integer mBCCH;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMBCCH")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBCCH)))
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

            mBCCH = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMBCCH info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBCCH = info.mBCCH;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBCCH = null;
    }

    public String ToString()
    {
        if (mBCCH == null)
            return "";
        else
            return String.format("%s", mBCCH);
    }

    public String GetTypeName()
    {
        return "Models.CGSMBCCH";
    }
}

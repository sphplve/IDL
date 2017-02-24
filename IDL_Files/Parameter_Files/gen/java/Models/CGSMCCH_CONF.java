
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCCH_CONF extends CRadioMeasParam
{
    public Short mCCH_CONF;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCCH_CONF")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCCH_CONF)))
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

            mCCH_CONF = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCCH_CONF info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCCH_CONF = info.mCCH_CONF;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCCH_CONF = null;
    }

    public String ToString()
    {
        if (mCCH_CONF == null)
            return "";
        else
            return String.format("%s", mCCH_CONF);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCCH_CONF";
    }
}

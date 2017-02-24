
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSServURAIDCount extends CRadioMeasParam
{
    public Long mServURAIDCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSServURAIDCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mServURAIDCount)))
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

            mServURAIDCount = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSServURAIDCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mServURAIDCount = info.mServURAIDCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mServURAIDCount = null;
    }

    public String ToString()
    {
        if (mServURAIDCount == null)
            return "";
        else
            return String.format("%s", mServURAIDCount);
    }

    public String GetTypeName()
    {
        return "Models.CTDSServURAIDCount";
    }
}

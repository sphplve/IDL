
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMaxUEPower extends CRadioMeasParam
{
    public Integer mMaxUEPower;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMaxUEPower")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMaxUEPower)))
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

            mMaxUEPower = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMaxUEPower info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaxUEPower = info.mMaxUEPower;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaxUEPower = null;
    }

    public String ToString()
    {
        if (mMaxUEPower == null)
            return "";
        else
            return String.format("%s", mMaxUEPower);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMaxUEPower";
    }
}

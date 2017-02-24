
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMBand extends CRadioMeasParam
{
    public Integer mBand;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMBand")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBand)))
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

            mBand = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMBand info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBand = info.mBand;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBand = null;
    }

    public String ToString()
    {
        if (mBand == null)
            return "";
        else
            return String.format("%s", mBand);
    }

    public String GetTypeName()
    {
        return "Models.CGSMBand";
    }
}

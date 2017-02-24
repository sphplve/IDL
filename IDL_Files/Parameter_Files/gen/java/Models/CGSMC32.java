
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMC32 extends CRadioMeasParam
{
    public Integer mC32;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMC32")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC32)))
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

            mC32 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMC32 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mC32 = info.mC32;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mC32 = null;
    }

    public String ToString()
    {
        if (mC32 == null)
            return "";
        else
            return String.format("%s", mC32);
    }

    public String GetTypeName()
    {
        return "Models.CGSMC32";
    }
}

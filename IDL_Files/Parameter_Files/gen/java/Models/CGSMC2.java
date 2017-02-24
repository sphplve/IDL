
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMC2 extends CRadioMeasParam
{
    public Integer mC2;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMC2")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC2)))
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

            mC2 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMC2 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mC2 = info.mC2;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mC2 = null;
    }

    public String ToString()
    {
        if (mC2 == null)
            return "";
        else
            return String.format("%s", mC2);
    }

    public String GetTypeName()
    {
        return "Models.CGSMC2";
    }
}

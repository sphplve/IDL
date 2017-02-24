
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMC31 extends CRadioMeasParam
{
    public Integer mC31;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMC31")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC31)))
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

            mC31 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMC31 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mC31 = info.mC31;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mC31 = null;
    }

    public String ToString()
    {
        if (mC31 == null)
            return "";
        else
            return String.format("%s", mC31);
    }

    public String GetTypeName()
    {
        return "Models.CGSMC31";
    }
}

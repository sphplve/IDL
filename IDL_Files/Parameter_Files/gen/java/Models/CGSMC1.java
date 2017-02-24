
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMC1 extends CRadioMeasParam
{
    public Integer mC1;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMC1")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC1)))
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

            mC1 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMC1 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mC1 = info.mC1;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mC1 = null;
    }

    public String ToString()
    {
        if (mC1 == null)
            return "";
        else
            return String.format("%s", mC1);
    }

    public String GetTypeName()
    {
        return "Models.CGSMC1";
    }
}

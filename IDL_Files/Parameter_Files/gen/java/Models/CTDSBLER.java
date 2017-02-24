
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSBLER extends CRadioMeasParam
{
    public Double mBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mBLER)))
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

            mBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBLER = info.mBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBLER = null;
    }

    public String ToString()
    {
        if (mBLER == null)
            return "";
        else
            return String.format("%s", mBLER);
    }

    public String GetTypeName()
    {
        return "Models.CTDSBLER";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERSSI extends CRadioMeasParam
{
    public Double mRSSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERSSI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRSSI)))
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

            mRSSI = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERSSI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRSSI = info.mRSSI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRSSI = null;
    }

    public String ToString()
    {
        if (mRSSI == null)
            return "";
        else
            return String.format("%s", mRSSI);
    }

    public String GetTypeName()
    {
        return "Models.CLTERSSI";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERSRP extends CRadioMeasParam
{
    public Double mRSRP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERSRP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRSRP)))
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

            mRSRP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERSRP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRSRP = info.mRSRP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRSRP = null;
    }

    public String ToString()
    {
        if (mRSRP == null)
            return "";
        else
            return String.format("%s", mRSRP);
    }

    public String GetTypeName()
    {
        return "Models.CLTERSRP";
    }
}

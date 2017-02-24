
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERANK1_SINR extends CRadioMeasParam
{
    public Double mRANK1_SINR;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERANK1_SINR")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mRANK1_SINR)))
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

            mRANK1_SINR = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERANK1_SINR info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRANK1_SINR = info.mRANK1_SINR;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRANK1_SINR = null;
    }

    public String ToString()
    {
        if (mRANK1_SINR == null)
            return "";
        else
            return String.format("%s", mRANK1_SINR);
    }

    public String GetTypeName()
    {
        return "Models.CLTERANK1_SINR";
    }
}

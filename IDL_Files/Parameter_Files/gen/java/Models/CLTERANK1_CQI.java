
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERANK1_CQI extends CRadioMeasParam
{
    public Short mRANK1_CQI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERANK1_CQI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRANK1_CQI)))
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

            mRANK1_CQI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERANK1_CQI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRANK1_CQI = info.mRANK1_CQI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRANK1_CQI = null;
    }

    public String ToString()
    {
        if (mRANK1_CQI == null)
            return "";
        else
            return String.format("%s", mRANK1_CQI);
    }

    public String GetTypeName()
    {
        return "Models.CLTERANK1_CQI";
    }
}

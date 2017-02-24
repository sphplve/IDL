
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERANK2_CQI_code0 extends CRadioMeasParam
{
    public Short mRANK2_CQI_code0;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERANK2_CQI_code0")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRANK2_CQI_code0)))
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

            mRANK2_CQI_code0 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERANK2_CQI_code0 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRANK2_CQI_code0 = info.mRANK2_CQI_code0;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRANK2_CQI_code0 = null;
    }

    public String ToString()
    {
        if (mRANK2_CQI_code0 == null)
            return "";
        else
            return String.format("%s", mRANK2_CQI_code0);
    }

    public String GetTypeName()
    {
        return "Models.CLTERANK2_CQI_code0";
    }
}

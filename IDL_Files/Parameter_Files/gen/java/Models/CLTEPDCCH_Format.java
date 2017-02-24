
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_Format extends CRadioMeasParam
{
    public Short mPDCCH_Format;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_Format")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPDCCH_Format)))
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

            mPDCCH_Format = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_Format info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_Format = info.mPDCCH_Format;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_Format = null;
    }

    public String ToString()
    {
        if (mPDCCH_Format == null)
            return "";
        else
            return String.format("%s", mPDCCH_Format);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_Format";
    }
}

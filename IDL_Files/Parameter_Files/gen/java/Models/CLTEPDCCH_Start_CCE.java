
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_Start_CCE extends CRadioMeasParam
{
    public Integer mPDCCH_Start_CCE;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_Start_CCE")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPDCCH_Start_CCE)))
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

            mPDCCH_Start_CCE = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDCCH_Start_CCE info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDCCH_Start_CCE = info.mPDCCH_Start_CCE;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDCCH_Start_CCE = null;
    }

    public String ToString()
    {
        if (mPDCCH_Start_CCE == null)
            return "";
        else
            return String.format("%s", mPDCCH_Start_CCE);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDCCH_Start_CCE";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPDSCH_CRC_Error extends CRadioMeasParam
{
    public Long mPDSCH_CRC_Error;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPDSCH_CRC_Error")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCH_CRC_Error)))
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

            mPDSCH_CRC_Error = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPDSCH_CRC_Error info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCH_CRC_Error = info.mPDSCH_CRC_Error;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCH_CRC_Error = null;
    }

    public String ToString()
    {
        if (mPDSCH_CRC_Error == null)
            return "";
        else
            return String.format("%s", mPDSCH_CRC_Error);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPDSCH_CRC_Error";
    }
}

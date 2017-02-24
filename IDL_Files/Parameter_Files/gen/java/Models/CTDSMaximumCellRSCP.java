
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSMaximumCellRSCP extends CRadioMeasParam
{
    public Double mMaximumCellRSCP;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSMaximumCellRSCP")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mMaximumCellRSCP)))
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

            mMaximumCellRSCP = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSMaximumCellRSCP info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaximumCellRSCP = info.mMaximumCellRSCP;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaximumCellRSCP = null;
    }

    public String ToString()
    {
        if (mMaximumCellRSCP == null)
            return "";
        else
            return String.format("%s", mMaximumCellRSCP);
    }

    public String GetTypeName()
    {
        return "Models.CTDSMaximumCellRSCP";
    }
}

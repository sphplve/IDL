
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECQIReportMode extends CRadioMeasParam
{
    public String mCQIReportMode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECQIReportMode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mCQIReportMode)))
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

            mCQIReportMode = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECQIReportMode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCQIReportMode = info.mCQIReportMode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCQIReportMode = null;
    }

    public String ToString()
    {
        if (mCQIReportMode == null)
            return String.format("");
        else
            return mCQIReportMode;
    }

    public String GetTypeName()
    {
        return "Models.CLTECQIReportMode";
    }
}

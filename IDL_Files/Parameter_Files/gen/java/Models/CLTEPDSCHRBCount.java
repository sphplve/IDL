
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPDSCHRBCount extends CRadioMeasParam
{
    public Long mPDSCHRBCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDSCHRBCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPDSCHRBCount)))
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

            mPDSCHRBCount = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPDSCHRBCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPDSCHRBCount = info.mPDSCHRBCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPDSCHRBCount = null;
    }

    public String ToString()
    {
        if (mPDSCHRBCount == null)
            return "";
        else
            return String.format("%s", mPDSCHRBCount);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPDSCHRBCount";
    }
}

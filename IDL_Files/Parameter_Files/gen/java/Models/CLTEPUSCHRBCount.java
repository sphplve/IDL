
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHRBCount extends CRadioMeasParam
{
    public Long mPUSCHRBCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHRBCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mPUSCHRBCount)))
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

            mPUSCHRBCount = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHRBCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHRBCount = info.mPUSCHRBCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHRBCount = null;
    }

    public String ToString()
    {
        if (mPUSCHRBCount == null)
            return "";
        else
            return String.format("%s", mPUSCHRBCount);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHRBCount";
    }
}

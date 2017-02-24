
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEBearerContextID extends CRadioMeasParam
{
    public Short mBearerContextID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEBearerContextID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mBearerContextID)))
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

            mBearerContextID = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEBearerContextID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBearerContextID = info.mBearerContextID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBearerContextID = null;
    }

    public String ToString()
    {
        if (mBearerContextID == null)
            return "";
        else
            return String.format("%s", mBearerContextID);
    }

    public String GetTypeName()
    {
        return "Models.CLTEBearerContextID";
    }
}

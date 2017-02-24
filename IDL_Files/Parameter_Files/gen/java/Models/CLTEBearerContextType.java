
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEBearerContextType extends CRadioMeasParam
{
    public Short mBearerContextType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEBearerContextType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mBearerContextType)))
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

            mBearerContextType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEBearerContextType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBearerContextType = info.mBearerContextType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBearerContextType = null;
    }

    public String ToString()
    {
        if (mBearerContextType == null)
            return "";
        else
            return String.format("%s", mBearerContextType);
    }

    public String GetTypeName()
    {
        return "Models.CLTEBearerContextType";
    }
}

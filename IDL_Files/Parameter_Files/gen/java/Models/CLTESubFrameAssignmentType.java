
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESubFrameAssignmentType extends CRadioMeasParam
{
    public String mSubFrameAssignmentType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESubFrameAssignmentType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mSubFrameAssignmentType)))
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

            mSubFrameAssignmentType = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESubFrameAssignmentType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSubFrameAssignmentType = info.mSubFrameAssignmentType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSubFrameAssignmentType = null;
    }

    public String ToString()
    {
        if (mSubFrameAssignmentType == null)
            return String.format("");
        else
            return mSubFrameAssignmentType;
    }

    public String GetTypeName()
    {
        return "Models.CLTESubFrameAssignmentType";
    }
}

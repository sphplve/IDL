
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxQualSub extends CRadioMeasParam
{
    public Short mRxQualSub;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxQualSub")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRxQualSub)))
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

            mRxQualSub = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxQualSub info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxQualSub = info.mRxQualSub;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxQualSub = null;
    }

    public String ToString()
    {
        if (mRxQualSub == null)
            return "";
        else
            return String.format("%s", mRxQualSub);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxQualSub";
    }
}

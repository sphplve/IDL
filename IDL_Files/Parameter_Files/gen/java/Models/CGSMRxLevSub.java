
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxLevSub extends CRadioMeasParam
{
    public Short mRxLevSub;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxLevSub")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRxLevSub)))
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

            mRxLevSub = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxLevSub info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxLevSub = info.mRxLevSub;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxLevSub = null;
    }

    public String ToString()
    {
        if (mRxLevSub == null)
            return "";
        else
            return String.format("%s", mRxLevSub);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxLevSub";
    }
}

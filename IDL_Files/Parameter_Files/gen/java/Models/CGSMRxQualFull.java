
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxQualFull extends CRadioMeasParam
{
    public Short mRxQualFull;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxQualFull")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRxQualFull)))
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

            mRxQualFull = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxQualFull info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxQualFull = info.mRxQualFull;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxQualFull = null;
    }

    public String ToString()
    {
        if (mRxQualFull == null)
            return "";
        else
            return String.format("%s", mRxQualFull);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxQualFull";
    }
}

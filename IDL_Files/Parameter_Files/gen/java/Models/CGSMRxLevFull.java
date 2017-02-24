
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxLevFull extends CRadioMeasParam
{
    public Short mRxLevFull;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxLevFull")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRxLevFull)))
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

            mRxLevFull = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxLevFull info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxLevFull = info.mRxLevFull;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxLevFull = null;
    }

    public String ToString()
    {
        if (mRxLevFull == null)
            return "";
        else
            return String.format("%s", mRxLevFull);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxLevFull";
    }
}

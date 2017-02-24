
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTempOffset extends CRadioMeasParam
{
    public Short mTempOffset;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTempOffset")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTempOffset)))
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

            mTempOffset = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTempOffset info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTempOffset = info.mTempOffset;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTempOffset = null;
    }

    public String ToString()
    {
        if (mTempOffset == null)
            return "";
        else
            return String.format("%s", mTempOffset);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTempOffset";
    }
}

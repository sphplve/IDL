
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCROffset extends CRadioMeasParam
{
    public Short mCROffset;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCROffset")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCROffset)))
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

            mCROffset = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCROffset info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCROffset = info.mCROffset;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCROffset = null;
    }

    public String ToString()
    {
        if (mCROffset == null)
            return "";
        else
            return String.format("%s", mCROffset);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCROffset";
    }
}

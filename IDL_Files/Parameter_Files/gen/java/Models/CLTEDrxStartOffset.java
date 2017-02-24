
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDrxStartOffset extends CRadioMeasParam
{
    public Integer mDrxStartOffset;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDrxStartOffset")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDrxStartOffset)))
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

            mDrxStartOffset = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDrxStartOffset info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDrxStartOffset = info.mDrxStartOffset;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDrxStartOffset = null;
    }

    public String ToString()
    {
        if (mDrxStartOffset == null)
            return "";
        else
            return String.format("%s", mDrxStartOffset);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDrxStartOffset";
    }
}

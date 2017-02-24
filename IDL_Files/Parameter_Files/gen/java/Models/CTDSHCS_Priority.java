
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHCS_Priority extends CRadioMeasParam
{
    public Short mHCS_Priority;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHCS_Priority")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHCS_Priority)))
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

            mHCS_Priority = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHCS_Priority info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHCS_Priority = info.mHCS_Priority;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHCS_Priority = null;
    }

    public String ToString()
    {
        if (mHCS_Priority == null)
            return "";
        else
            return String.format("%s", mHCS_Priority);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHCS_Priority";
    }
}

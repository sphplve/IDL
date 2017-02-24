
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCCCH_Channel_Count extends CRadioMeasParam
{
    public Short mCCCH_Channel_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCCCH_Channel_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCCCH_Channel_Count)))
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

            mCCCH_Channel_Count = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCCCH_Channel_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCCCH_Channel_Count = info.mCCCH_Channel_Count;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCCCH_Channel_Count = null;
    }

    public String ToString()
    {
        if (mCCCH_Channel_Count == null)
            return "";
        else
            return String.format("%s", mCCCH_Channel_Count);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCCCH_Channel_Count";
    }
}

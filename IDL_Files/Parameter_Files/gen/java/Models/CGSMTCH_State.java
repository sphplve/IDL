
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTCH_State extends CRadioMeasParam
{
    public Short mTCH_State;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTCH_State")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTCH_State)))
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

            mTCH_State = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTCH_State info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTCH_State = info.mTCH_State;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTCH_State = null;
    }

    public String ToString()
    {
        if (mTCH_State == null)
            return "";
        else
            return String.format("%s", mTCH_State);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTCH_State";
    }
}

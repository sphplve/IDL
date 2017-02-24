
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRR_State extends CRadioMeasParam
{
    public Short mRR_State;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRR_State")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRR_State)))
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

            mRR_State = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRR_State info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRR_State = info.mRR_State;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRR_State = null;
    }

    public String ToString()
    {
        if (mRR_State == null)
            return "";
        else
            return String.format("%s", mRR_State);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRR_State";
    }
}

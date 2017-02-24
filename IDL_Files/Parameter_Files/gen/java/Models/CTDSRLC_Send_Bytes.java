
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSRLC_Send_Bytes extends CRadioMeasParam
{
    public Long mRLC_Send_Bytes;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRLC_Send_Bytes")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mRLC_Send_Bytes)))
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

            mRLC_Send_Bytes = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRLC_Send_Bytes info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRLC_Send_Bytes = info.mRLC_Send_Bytes;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRLC_Send_Bytes = null;
    }

    public String ToString()
    {
        if (mRLC_Send_Bytes == null)
            return "";
        else
            return String.format("%s", mRLC_Send_Bytes);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRLC_Send_Bytes";
    }
}

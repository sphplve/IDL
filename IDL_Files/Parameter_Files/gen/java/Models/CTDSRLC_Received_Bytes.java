
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSRLC_Received_Bytes extends CRadioMeasParam
{
    public Long mRLC_Received_Bytes;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRLC_Received_Bytes")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mRLC_Received_Bytes)))
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

            mRLC_Received_Bytes = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRLC_Received_Bytes info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRLC_Received_Bytes = info.mRLC_Received_Bytes;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRLC_Received_Bytes = null;
    }

    public String ToString()
    {
        if (mRLC_Received_Bytes == null)
            return "";
        else
            return String.format("%s", mRLC_Received_Bytes);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRLC_Received_Bytes";
    }
}

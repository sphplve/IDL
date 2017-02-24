
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUuDPCHTimeslotCount extends CRadioMeasParam
{
    public Integer mUuDPCHTimeslotCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUuDPCHTimeslotCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUuDPCHTimeslotCount)))
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

            mUuDPCHTimeslotCount = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUuDPCHTimeslotCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUuDPCHTimeslotCount = info.mUuDPCHTimeslotCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUuDPCHTimeslotCount = null;
    }

    public String ToString()
    {
        if (mUuDPCHTimeslotCount == null)
            return "";
        else
            return String.format("%s", mUuDPCHTimeslotCount);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUuDPCHTimeslotCount";
    }
}

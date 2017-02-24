
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSUuTimeslotISCPCount extends CRadioMeasParam
{
    public Integer mUuTimeslotISCPCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSUuTimeslotISCPCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUuTimeslotISCPCount)))
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

            mUuTimeslotISCPCount = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSUuTimeslotISCPCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUuTimeslotISCPCount = info.mUuTimeslotISCPCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUuTimeslotISCPCount = null;
    }

    public String ToString()
    {
        if (mUuTimeslotISCPCount == null)
            return "";
        else
            return String.format("%s", mUuTimeslotISCPCount);
    }

    public String GetTypeName()
    {
        return "Models.CTDSUuTimeslotISCPCount";
    }
}

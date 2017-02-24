
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCurrent_PICH_SFN extends CRadioMeasParam
{
    public Integer mCurrent_PICH_SFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCurrent_PICH_SFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCurrent_PICH_SFN)))
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

            mCurrent_PICH_SFN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCurrent_PICH_SFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCurrent_PICH_SFN = info.mCurrent_PICH_SFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCurrent_PICH_SFN = null;
    }

    public String ToString()
    {
        if (mCurrent_PICH_SFN == null)
            return "";
        else
            return String.format("%s", mCurrent_PICH_SFN);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCurrent_PICH_SFN";
    }
}

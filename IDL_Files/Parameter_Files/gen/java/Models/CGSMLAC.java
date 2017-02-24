
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMLAC extends CRadioMeasParam
{
    public Integer mLAC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMLAC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mLAC)))
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

            mLAC = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMLAC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mLAC = info.mLAC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mLAC = null;
    }

    public String ToString()
    {
        if (mLAC == null)
            return "";
        else
            return String.format("%s", mLAC);
    }

    public String GetTypeName()
    {
        return "Models.CGSMLAC";
    }
}

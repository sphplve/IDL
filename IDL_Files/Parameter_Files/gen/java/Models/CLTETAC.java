
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTETAC extends CRadioMeasParam
{
    public Integer mTAC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTETAC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTAC)))
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

            mTAC = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTETAC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTAC = info.mTAC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTAC = null;
    }

    public String ToString()
    {
        if (mTAC == null)
            return "";
        else
            return String.format("%s", mTAC);
    }

    public String GetTypeName()
    {
        return "Models.CLTETAC";
    }
}

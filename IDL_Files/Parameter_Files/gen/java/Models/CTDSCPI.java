
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCPI extends CRadioMeasParam
{
    public Integer mCPI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCPI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCPI)))
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

            mCPI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCPI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCPI = info.mCPI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCPI = null;
    }

    public String ToString()
    {
        if (mCPI == null)
            return "";
        else
            return String.format("%s", mCPI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCPI";
    }
}

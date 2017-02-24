
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRLC_Mode extends CRadioMeasParam
{
    public String mRLC_Mode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRLC_Mode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mRLC_Mode)))
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

            mRLC_Mode = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRLC_Mode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRLC_Mode = info.mRLC_Mode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRLC_Mode = null;
    }

    public String ToString()
    {
        if (mRLC_Mode == null)
            return String.format("");
        else
            return mRLC_Mode;
    }

    public String GetTypeName()
    {
        return "Models.CGSMRLC_Mode";
    }
}

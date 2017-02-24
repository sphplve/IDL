
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_TTI extends CRadioMeasParam
{
    public Short mPRACH_TTI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_TTI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPRACH_TTI)))
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

            mPRACH_TTI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_TTI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_TTI = info.mPRACH_TTI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_TTI = null;
    }

    public String ToString()
    {
        if (mPRACH_TTI == null)
            return "";
        else
            return String.format("%s", mPRACH_TTI);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_TTI";
    }
}

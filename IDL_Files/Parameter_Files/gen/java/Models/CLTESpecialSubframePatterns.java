
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESpecialSubframePatterns extends CRadioMeasParam
{
    public String mSpecialSubframePatterns;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESpecialSubframePatterns")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mSpecialSubframePatterns)))
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

            mSpecialSubframePatterns = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESpecialSubframePatterns info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSpecialSubframePatterns = info.mSpecialSubframePatterns;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSpecialSubframePatterns = null;
    }

    public String ToString()
    {
        if (mSpecialSubframePatterns == null)
            return String.format("");
        else
            return mSpecialSubframePatterns;
    }

    public String GetTypeName()
    {
        return "Models.CLTESpecialSubframePatterns";
    }
}

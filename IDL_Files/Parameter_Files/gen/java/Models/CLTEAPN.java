
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEAPN extends CRadioMeasParam
{
    public String mAPN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEAPN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mAPN)))
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

            mAPN = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEAPN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAPN = info.mAPN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAPN = null;
    }

    public String ToString()
    {
        if (mAPN == null)
            return String.format("");
        else
            return mAPN;
    }

    public String GetTypeName()
    {
        return "Models.CLTEAPN";
    }
}

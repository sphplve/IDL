
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMVCodec extends CRadioMeasParam
{
    public String mVCodec;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMVCodec")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mVCodec)))
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

            mVCodec = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMVCodec info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mVCodec = info.mVCodec;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mVCodec = null;
    }

    public String ToString()
    {
        if (mVCodec == null)
            return String.format("");
        else
            return mVCodec;
    }

    public String GetTypeName()
    {
        return "Models.CGSMVCodec";
    }
}

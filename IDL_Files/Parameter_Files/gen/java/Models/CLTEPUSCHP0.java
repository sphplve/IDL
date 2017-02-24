
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHP0 extends CRadioMeasParam
{
    public Byte mPUSCHP0;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHP0")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mPUSCHP0)))
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

            mPUSCHP0 = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHP0 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHP0 = info.mPUSCHP0;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHP0 = null;
    }

    public String ToString()
    {
        if (mPUSCHP0 == null)
            return "";
        else
            return String.format("%s", mPUSCHP0);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHP0";
    }
}

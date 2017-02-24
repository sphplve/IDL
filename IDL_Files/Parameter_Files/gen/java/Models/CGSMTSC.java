
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMTSC extends CRadioMeasParam
{
    public Short mTSC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMTSC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTSC)))
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

            mTSC = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMTSC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTSC = info.mTSC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTSC = null;
    }

    public String ToString()
    {
        if (mTSC == null)
            return "";
        else
            return String.format("%s", mTSC);
    }

    public String GetTypeName()
    {
        return "Models.CGSMTSC";
    }
}

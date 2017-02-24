
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEULFreq extends CRadioMeasParam
{
    public Integer mULFreq;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEULFreq")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mULFreq)))
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

            mULFreq = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEULFreq info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mULFreq = info.mULFreq;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mULFreq = null;
    }

    public String ToString()
    {
        if (mULFreq == null)
            return "";
        else
            return String.format("%s", mULFreq);
    }

    public String GetTypeName()
    {
        return "Models.CLTEULFreq";
    }
}

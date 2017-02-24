
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLFreq extends CRadioMeasParam
{
    public Integer mDLFreq;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLFreq")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mDLFreq)))
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

            mDLFreq = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLFreq info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLFreq = info.mDLFreq;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLFreq = null;
    }

    public String ToString()
    {
        if (mDLFreq == null)
            return "";
        else
            return String.format("%s", mDLFreq);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLFreq";
    }
}

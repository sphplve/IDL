
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHFi extends CRadioMeasParam
{
    public Short mPUSCHFi;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHFi")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mPUSCHFi)))
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

            mPUSCHFi = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHFi info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHFi = info.mPUSCHFi;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHFi = null;
    }

    public String ToString()
    {
        if (mPUSCHFi == null)
            return "";
        else
            return String.format("%s", mPUSCHFi);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHFi";
    }
}

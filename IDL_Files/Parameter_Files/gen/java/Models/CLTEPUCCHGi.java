
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUCCHGi extends CRadioMeasParam
{
    public Short mPUCCHGi;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUCCHGi")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mPUCCHGi)))
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

            mPUCCHGi = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUCCHGi info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUCCHGi = info.mPUCCHGi;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUCCHGi = null;
    }

    public String ToString()
    {
        if (mPUCCHGi == null)
            return "";
        else
            return String.format("%s", mPUCCHGi);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUCCHGi";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHSchedulingBLER extends CRadioMeasParam
{
    public Double mPUSCHSchedulingBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHSchedulingBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHSchedulingBLER)))
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

            mPUSCHSchedulingBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHSchedulingBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHSchedulingBLER = info.mPUSCHSchedulingBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHSchedulingBLER = null;
    }

    public String ToString()
    {
        if (mPUSCHSchedulingBLER == null)
            return "";
        else
            return String.format("%s", mPUSCHSchedulingBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHSchedulingBLER";
    }
}

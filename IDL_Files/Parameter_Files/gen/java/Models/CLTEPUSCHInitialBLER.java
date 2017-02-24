
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPUSCHInitialBLER extends CRadioMeasParam
{
    public Double mPUSCHInitialBLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPUSCHInitialBLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mPUSCHInitialBLER)))
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

            mPUSCHInitialBLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPUSCHInitialBLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPUSCHInitialBLER = info.mPUSCHInitialBLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPUSCHInitialBLER = null;
    }

    public String ToString()
    {
        if (mPUSCHInitialBLER == null)
            return "";
        else
            return String.format("%s", mPUSCHInitialBLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPUSCHInitialBLER";
    }
}

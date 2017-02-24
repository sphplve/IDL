
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstReTxUL extends CRadioMeasParam
{
    public Integer mFirstReTxUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstReTxUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstReTxUL)))
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

            mFirstReTxUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstReTxUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstReTxUL = info.mFirstReTxUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstReTxUL = null;
    }

    public String ToString()
    {
        if (mFirstReTxUL == null)
            return "";
        else
            return String.format("%s", mFirstReTxUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstReTxUL";
    }
}

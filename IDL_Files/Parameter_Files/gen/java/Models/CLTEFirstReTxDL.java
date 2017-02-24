
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstReTxDL extends CRadioMeasParam
{
    public Integer mFirstReTxDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstReTxDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstReTxDL)))
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

            mFirstReTxDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstReTxDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstReTxDL = info.mFirstReTxDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstReTxDL = null;
    }

    public String ToString()
    {
        if (mFirstReTxDL == null)
            return "";
        else
            return String.format("%s", mFirstReTxDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstReTxDL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstTransferUL extends CRadioMeasParam
{
    public Integer mFirstTransferUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstTransferUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstTransferUL)))
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

            mFirstTransferUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstTransferUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstTransferUL = info.mFirstTransferUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstTransferUL = null;
    }

    public String ToString()
    {
        if (mFirstTransferUL == null)
            return "";
        else
            return String.format("%s", mFirstTransferUL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstTransferUL";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstTransferDL extends CRadioMeasParam
{
    public Integer mFirstTransferDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstTransferDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstTransferDL)))
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

            mFirstTransferDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstTransferDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstTransferDL = info.mFirstTransferDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstTransferDL = null;
    }

    public String ToString()
    {
        if (mFirstTransferDL == null)
            return "";
        else
            return String.format("%s", mFirstTransferDL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstTransferDL";
    }
}

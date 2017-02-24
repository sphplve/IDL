
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFirstTransfer_code1_DL extends CRadioMeasParam
{
    public Integer mFirstTransfer_code1_DL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFirstTransfer_code1_DL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFirstTransfer_code1_DL)))
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

            mFirstTransfer_code1_DL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFirstTransfer_code1_DL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFirstTransfer_code1_DL = info.mFirstTransfer_code1_DL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFirstTransfer_code1_DL = null;
    }

    public String ToString()
    {
        if (mFirstTransfer_code1_DL == null)
            return "";
        else
            return String.format("%s", mFirstTransfer_code1_DL);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFirstTransfer_code1_DL";
    }
}

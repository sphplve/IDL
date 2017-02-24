
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSHARQ_Process_ID extends CRadioMeasParam
{
    public Short mHARQ_Process_ID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSHARQ_Process_ID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHARQ_Process_ID)))
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

            mHARQ_Process_ID = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSHARQ_Process_ID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHARQ_Process_ID = info.mHARQ_Process_ID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHARQ_Process_ID = null;
    }

    public String ToString()
    {
        if (mHARQ_Process_ID == null)
            return "";
        else
            return String.format("%s", mHARQ_Process_ID);
    }

    public String GetTypeName()
    {
        return "Models.CTDSHARQ_Process_ID";
    }
}

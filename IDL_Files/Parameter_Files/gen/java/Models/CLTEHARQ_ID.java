
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEHARQ_ID extends CRadioMeasParam
{
    public Short mHARQ_ID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEHARQ_ID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHARQ_ID)))
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

            mHARQ_ID = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEHARQ_ID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHARQ_ID = info.mHARQ_ID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHARQ_ID = null;
    }

    public String ToString()
    {
        if (mHARQ_ID == null)
            return "";
        else
            return String.format("%s", mHARQ_ID);
    }

    public String GetTypeName()
    {
        return "Models.CLTEHARQ_ID";
    }
}

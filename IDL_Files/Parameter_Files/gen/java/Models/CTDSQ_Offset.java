
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSQ_Offset extends CRadioMeasParam
{
    public Short mQ_Offset;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSQ_Offset")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mQ_Offset)))
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

            mQ_Offset = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSQ_Offset info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQ_Offset = info.mQ_Offset;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQ_Offset = null;
    }

    public String ToString()
    {
        if (mQ_Offset == null)
            return "";
        else
            return String.format("%s", mQ_Offset);
    }

    public String GetTypeName()
    {
        return "Models.CTDSQ_Offset";
    }
}

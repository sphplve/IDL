
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMaxReTxCount extends CRadioMeasParam
{
    public Integer mMaxReTxCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMaxReTxCount")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMaxReTxCount)))
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

            mMaxReTxCount = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMaxReTxCount info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaxReTxCount = info.mMaxReTxCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaxReTxCount = null;
    }

    public String ToString()
    {
        if (mMaxReTxCount == null)
            return "";
        else
            return String.format("%s", mMaxReTxCount);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMaxReTxCount";
    }
}

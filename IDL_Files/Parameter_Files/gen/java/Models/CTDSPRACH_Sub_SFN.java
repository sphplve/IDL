
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_Sub_SFN extends CRadioMeasParam
{
    public Integer mPRACH_Sub_SFN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_Sub_SFN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPRACH_Sub_SFN)))
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

            mPRACH_Sub_SFN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_Sub_SFN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_Sub_SFN = info.mPRACH_Sub_SFN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_Sub_SFN = null;
    }

    public String ToString()
    {
        if (mPRACH_Sub_SFN == null)
            return "";
        else
            return String.format("%s", mPRACH_Sub_SFN);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_Sub_SFN";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPRACH_TSN extends CRadioMeasParam
{
    public Short mPRACH_TSN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPRACH_TSN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPRACH_TSN)))
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

            mPRACH_TSN = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPRACH_TSN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPRACH_TSN = info.mPRACH_TSN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPRACH_TSN = null;
    }

    public String ToString()
    {
        if (mPRACH_TSN == null)
            return "";
        else
            return String.format("%s", mPRACH_TSN);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPRACH_TSN";
    }
}

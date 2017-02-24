
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxLevelAccessMin extends CRadioMeasParam
{
    public Short mRxLevelAccessMin;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxLevelAccessMin")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRxLevelAccessMin)))
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

            mRxLevelAccessMin = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxLevelAccessMin info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxLevelAccessMin = info.mRxLevelAccessMin;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxLevelAccessMin = null;
    }

    public String ToString()
    {
        if (mRxLevelAccessMin == null)
            return "";
        else
            return String.format("%s", mRxLevelAccessMin);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxLevelAccessMin";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CCQTMap extends CRadioMeasParam
{
    // 0：打点 1：清除 2：撤销 3：重新打点
    public short mAction;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CCQTMap")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mAction)))
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

            mAction = parcel.ReadUInt8();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CCQTMap info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAction = info.mAction;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAction = 0;
    }

    public String ToString()
    {
        return String.format("%s", mAction);
    }

    public String GetTypeName()
    {
        return "Models.CCQTMap";
    }
}

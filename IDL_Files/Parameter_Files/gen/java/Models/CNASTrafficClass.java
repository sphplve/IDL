
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASTrafficClass extends CRadioMeasParam
{
    public Short mTrafficClass;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASTrafficClass")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTrafficClass)))
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

            mTrafficClass = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASTrafficClass info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTrafficClass = info.mTrafficClass;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTrafficClass = null;
    }

    public String ToString()
    {
        if (mTrafficClass == null)
            return "";
        else
            return String.format("%s", mTrafficClass);
    }

    public String GetTypeName()
    {
        return "Models.CNASTrafficClass";
    }
}

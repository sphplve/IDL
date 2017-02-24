
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMReliabilityClass extends CRadioMeasParam
{
    public Short mReliabilityClass;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMReliabilityClass")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mReliabilityClass)))
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

            mReliabilityClass = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMReliabilityClass info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mReliabilityClass = info.mReliabilityClass;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mReliabilityClass = null;
    }

    public String ToString()
    {
        if (mReliabilityClass == null)
            return "";
        else
            return String.format("%s", mReliabilityClass);
    }

    public String GetTypeName()
    {
        return "Models.CGSMReliabilityClass";
    }
}

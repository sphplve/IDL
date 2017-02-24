
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEExtendedServiceType extends CRadioMeasParam
{
    public Short mExtendedServiceType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEExtendedServiceType")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mExtendedServiceType)))
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

            mExtendedServiceType = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEExtendedServiceType info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mExtendedServiceType = info.mExtendedServiceType;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mExtendedServiceType = null;
    }

    public String ToString()
    {
        if (mExtendedServiceType == null)
            return "";
        else
            return String.format("%s", mExtendedServiceType);
    }

    public String GetTypeName()
    {
        return "Models.CLTEExtendedServiceType";
    }
}

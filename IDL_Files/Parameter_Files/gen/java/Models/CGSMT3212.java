
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMT3212 extends CRadioMeasParam
{
    public Short mT3212;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMT3212")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mT3212)))
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

            mT3212 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMT3212 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mT3212 = info.mT3212;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mT3212 = null;
    }

    public String ToString()
    {
        if (mT3212 == null)
            return "";
        else
            return String.format("%s", mT3212);
    }

    public String GetTypeName()
    {
        return "Models.CGSMT3212";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMT3314 extends CRadioMeasParam
{
    public Short mT3314;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMT3314")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mT3314)))
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

            mT3314 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMT3314 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mT3314 = info.mT3314;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mT3314 = null;
    }

    public String ToString()
    {
        if (mT3314 == null)
            return "";
        else
            return String.format("%s", mT3314);
    }

    public String GetTypeName()
    {
        return "Models.CGSMT3314";
    }
}

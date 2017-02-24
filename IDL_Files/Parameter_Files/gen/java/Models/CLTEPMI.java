
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPMI extends CRadioMeasParam
{
    public Short mPMI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPMI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPMI)))
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

            mPMI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPMI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPMI = info.mPMI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPMI = null;
    }

    public String ToString()
    {
        if (mPMI == null)
            return "";
        else
            return String.format("%s", mPMI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPMI";
    }
}

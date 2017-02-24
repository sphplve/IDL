
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEQCI extends CRadioMeasParam
{
    public Integer mQCI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEQCI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mQCI)))
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

            mQCI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEQCI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQCI = info.mQCI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQCI = null;
    }

    public String ToString()
    {
        if (mQCI == null)
            return "";
        else
            return String.format("%s", mQCI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEQCI";
    }
}

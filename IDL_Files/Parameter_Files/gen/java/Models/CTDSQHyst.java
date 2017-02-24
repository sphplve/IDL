
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSQHyst extends CRadioMeasParam
{
    public Integer mQHyst;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSQHyst")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mQHyst)))
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

            mQHyst = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSQHyst info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQHyst = info.mQHyst;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQHyst = null;
    }

    public String ToString()
    {
        if (mQHyst == null)
            return "";
        else
            return String.format("%s", mQHyst);
    }

    public String GetTypeName()
    {
        return "Models.CTDSQHyst";
    }
}

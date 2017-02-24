
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCRHyst extends CRadioMeasParam
{
    public Short mCRHyst;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCRHyst")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCRHyst)))
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

            mCRHyst = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCRHyst info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCRHyst = info.mCRHyst;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCRHyst = null;
    }

    public String ToString()
    {
        if (mCRHyst == null)
            return "";
        else
            return String.format("%s", mCRHyst);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCRHyst";
    }
}

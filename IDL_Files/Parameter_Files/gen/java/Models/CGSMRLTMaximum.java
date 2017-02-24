
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRLTMaximum extends CRadioMeasParam
{
    public Short mRLTMaximum;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRLTMaximum")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRLTMaximum)))
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

            mRLTMaximum = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRLTMaximum info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRLTMaximum = info.mRLTMaximum;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRLTMaximum = null;
    }

    public String ToString()
    {
        if (mRLTMaximum == null)
            return "";
        else
            return String.format("%s", mRLTMaximum);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRLTMaximum";
    }
}

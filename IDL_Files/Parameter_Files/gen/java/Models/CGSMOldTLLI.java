
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMOldTLLI extends CRadioMeasParam
{
    public Long mOldTLLI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMOldTLLI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mOldTLLI)))
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

            mOldTLLI = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMOldTLLI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mOldTLLI = info.mOldTLLI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mOldTLLI = null;
    }

    public String ToString()
    {
        if (mOldTLLI == null)
            return "";
        else
            return String.format("%s", mOldTLLI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMOldTLLI";
    }
}

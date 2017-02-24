
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMNewTLLI extends CRadioMeasParam
{
    public Long mNewTLLI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNewTLLI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mNewTLLI)))
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

            mNewTLLI = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNewTLLI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNewTLLI = info.mNewTLLI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNewTLLI = null;
    }

    public String ToString()
    {
        if (mNewTLLI == null)
            return "";
        else
            return String.format("%s", mNewTLLI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNewTLLI";
    }
}

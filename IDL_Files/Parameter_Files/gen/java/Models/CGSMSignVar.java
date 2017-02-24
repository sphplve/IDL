
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMSignVar extends CRadioMeasParam
{
    public Short mSignVar;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMSignVar")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSignVar)))
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

            mSignVar = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMSignVar info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSignVar = info.mSignVar;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSignVar = null;
    }

    public String ToString()
    {
        if (mSignVar == null)
            return "";
        else
            return String.format("%s", mSignVar);
    }

    public String GetTypeName()
    {
        return "Models.CGSMSignVar";
    }
}

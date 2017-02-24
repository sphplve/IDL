
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASGMMState_G extends CRadioMeasParam
{
    public Short mGMMState_G;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASGMMState_G")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mGMMState_G)))
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

            mGMMState_G = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASGMMState_G info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGMMState_G = info.mGMMState_G;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGMMState_G = null;
    }

    public String ToString()
    {
        if (mGMMState_G == null)
            return "";
        else
            return String.format("%s", mGMMState_G);
    }

    public String GetTypeName()
    {
        return "Models.CNASGMMState_G";
    }
}

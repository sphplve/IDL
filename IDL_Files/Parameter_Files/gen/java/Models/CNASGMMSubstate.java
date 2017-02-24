
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASGMMSubstate extends CRadioMeasParam
{
    public Short mGMMSubstate;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASGMMSubstate")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mGMMSubstate)))
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

            mGMMSubstate = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASGMMSubstate info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGMMSubstate = info.mGMMSubstate;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGMMSubstate = null;
    }

    public String ToString()
    {
        if (mGMMSubstate == null)
            return "";
        else
            return String.format("%s", mGMMSubstate);
    }

    public String GetTypeName()
    {
        return "Models.CNASGMMSubstate";
    }
}

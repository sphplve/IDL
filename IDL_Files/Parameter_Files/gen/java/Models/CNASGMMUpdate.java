
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASGMMUpdate extends CRadioMeasParam
{
    public Short mGMMUpdate;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASGMMUpdate")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mGMMUpdate)))
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

            mGMMUpdate = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASGMMUpdate info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mGMMUpdate = info.mGMMUpdate;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mGMMUpdate = null;
    }

    public String ToString()
    {
        if (mGMMUpdate == null)
            return "";
        else
            return String.format("%s", mGMMUpdate);
    }

    public String GetTypeName()
    {
        return "Models.CNASGMMUpdate";
    }
}

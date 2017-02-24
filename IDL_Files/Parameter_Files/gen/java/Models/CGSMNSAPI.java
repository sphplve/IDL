
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMNSAPI extends CRadioMeasParam
{
    public Short mNSAPI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNSAPI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNSAPI)))
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

            mNSAPI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNSAPI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNSAPI = info.mNSAPI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNSAPI = null;
    }

    public String ToString()
    {
        if (mNSAPI == null)
            return "";
        else
            return String.format("%s", mNSAPI);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNSAPI";
    }
}


package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CNetworkInfo implements IParcelable
{
    public short mId;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNetworkInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mId)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mId = parcel.ReadUInt8();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNetworkInfo info)
    {
        if (info == null)
            return false;

        mId = info.mId;

        return true;
    }

    public void SetNull()
    {
        mId = 0;
    }

    public String ToString()
    {
        return String.format("%s", mId);
    }

    public String GetTypeName()
    {
        return "Models.CNetworkInfo";
    }
}

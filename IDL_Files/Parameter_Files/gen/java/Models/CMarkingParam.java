
package Models;

import java.math.BigInteger;
import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CMarkingParam implements IParcelable
{
    public short mType;
    public String mName;
    public BigInteger mTimeStamp;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CMarkingParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64(mTimeStamp)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mType = parcel.ReadUInt8();
            mName = parcel.ReadString();
            mTimeStamp = parcel.ReadUInt64();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CMarkingParam info)
    {
        if (info == null)
            return false;

        mType = info.mType;
        mName = info.mName;
        mTimeStamp = info.mTimeStamp;

        return true;
    }

    public void SetNull()
    {
        mType = 0;
        mName = null;
        mTimeStamp = new BigInteger("0");
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mType\":\"%s\",", json, mType);
        if (json == null)
            return null;

        if (mName == null) {
            json = String.format("%s\"mName\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mName\":\"%s\",", json, mName);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTimeStamp\":\"%s\"", json, mTimeStamp);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CMarkingParam";
    }
}

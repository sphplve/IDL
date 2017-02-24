
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CStatisticsInfo implements IParcelable
{
    public String mName;
    public double mValue;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CStatisticsInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble(mValue)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mName = parcel.ReadString();
            mValue = parcel.ReadDouble();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CStatisticsInfo info)
    {
        if (info == null)
            return false;

        mName = info.mName;
        mValue = info.mValue;

        return true;
    }

    public void SetNull()
    {
        mName = null;
        mValue = 0;
    }

    public String ToString()
    {
        String json = "{";
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

        json = String.format("%s\"mValue\":\"%s\"", json, mValue);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CStatisticsInfo";
    }
}

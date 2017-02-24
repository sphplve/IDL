
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CMapPoint extends CRadioMeasParam
{
    public Long mCellId;
    public short mNetwork;
    public Double mLatitude;
    public Double mLongitude;
    public String mName;
    public String mValue;
    public String mNeighborCellInfo;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CMapPoint")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mCellId)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mNetwork)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mLatitude)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mLongitude)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mValue)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mNeighborCellInfo)))
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

            mCellId = parcel.ReadUInt32$();
            mNetwork = parcel.ReadUInt8();
            mLatitude = parcel.ReadDouble$();
            mLongitude = parcel.ReadDouble$();
            mName = parcel.ReadString();
            mValue = parcel.ReadString();
            mNeighborCellInfo = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CMapPoint info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellId = info.mCellId;
        mNetwork = info.mNetwork;
        mLatitude = info.mLatitude;
        mLongitude = info.mLongitude;
        mName = info.mName;
        mValue = info.mValue;
        mNeighborCellInfo = info.mNeighborCellInfo;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellId = null;
        mNetwork = 0;
        mLatitude = null;
        mLongitude = null;
        mName = null;
        mValue = null;
        mNeighborCellInfo = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mCellId == null) {
            json = String.format("%s\"mCellId\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCellId\":\"%s\",", json, mCellId);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mNetwork\":\"%s\",", json, mNetwork);
        if (json == null)
            return null;

        if (mLatitude == null) {
            json = String.format("%s\"mLatitude\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mLatitude\":\"%s\",", json, mLatitude);
            if (json == null)
                return null;
        }

        if (mLongitude == null) {
            json = String.format("%s\"mLongitude\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mLongitude\":\"%s\",", json, mLongitude);
            if (json == null)
                return null;
        }

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

        if (mValue == null) {
            json = String.format("%s\"mValue\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mValue\":\"%s\",", json, mValue);
            if (json == null)
                return null;
        }

        if (mNeighborCellInfo == null) {
            json = String.format("%s\"mNeighborCellInfo\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mNeighborCellInfo\":\"%s\"", json, mNeighborCellInfo);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CMapPoint";
    }
}


package Models;

import java.math.BigInteger;
import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CRadioMeasParam implements IParcelable
{
    public String mType;
    public BigInteger mTimeStamp;
    public long mFrameId;
    public short mDeviceId;
    public Double mLatitude;
    public Double mLongitude;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CRadioMeasParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64(mTimeStamp)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32(mFrameId)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mDeviceId)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mLatitude)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mLongitude)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mType = parcel.ReadString();
            mTimeStamp = parcel.ReadUInt64();
            mFrameId = parcel.ReadUInt32();
            mDeviceId = parcel.ReadUInt8();
            mLatitude = parcel.ReadDouble$();
            mLongitude = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CRadioMeasParam info)
    {
        if (info == null)
            return false;

        mType = info.mType;
        mTimeStamp = info.mTimeStamp;
        mFrameId = info.mFrameId;
        mDeviceId = info.mDeviceId;
        mLatitude = info.mLatitude;
        mLongitude = info.mLongitude;

        return true;
    }

    public void SetNull()
    {
        mType = null;
        mTimeStamp = new BigInteger("0");
        mFrameId = 0;
        mDeviceId = 0;
        mLatitude = null;
        mLongitude = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mType == null) {
            json = String.format("%s\"mType\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mType\":\"%s\",", json, mType);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTimeStamp\":\"%s\",", json, mTimeStamp);
        if (json == null)
            return null;

        json = String.format("%s\"mFrameId\":\"%s\",", json, mFrameId);
        if (json == null)
            return null;

        json = String.format("%s\"mDeviceId\":\"%s\",", json, mDeviceId);
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
            json = String.format("%s\"mLongitude\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mLongitude\":\"%s\"", json, mLongitude);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CRadioMeasParam";
    }
}

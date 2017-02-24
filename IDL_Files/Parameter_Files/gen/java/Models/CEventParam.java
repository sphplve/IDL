
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CEventParam extends CRadioMeasParam
{
    public boolean mIsMarking;
    public Integer mLength;
    public Integer mEventId;
    public String mEventName;
    public Short mData;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CEventParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsMarking)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mLength)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mEventId)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mEventName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mData)))
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

            mIsMarking = parcel.ReadBoolean();
            mLength = parcel.ReadUInt16$();
            mEventId = parcel.ReadUInt16$();
            mEventName = parcel.ReadString();
            mData = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CEventParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIsMarking = info.mIsMarking;
        mLength = info.mLength;
        mEventId = info.mEventId;
        mEventName = info.mEventName;
        mData = info.mData;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIsMarking = false;
        mLength = null;
        mEventId = null;
        mEventName = null;
        mData = null;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mIsMarking\":\"%s\",", json, mIsMarking);
        if (json == null)
            return null;

        if (mLength == null) {
            json = String.format("%s\"mLength\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mLength\":\"%s\",", json, mLength);
            if (json == null)
                return null;
        }

        if (mEventId == null) {
            json = String.format("%s\"mEventId\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mEventId\":\"%s\",", json, mEventId);
            if (json == null)
                return null;
        }

        if (mEventName == null) {
            json = String.format("%s\"mEventName\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mEventName\":\"%s\",", json, mEventName);
            if (json == null)
                return null;
        }

        if (mData == null) {
            json = String.format("%s\"mData\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mData\":\"%s\"", json, mData);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CEventParam";
    }
}

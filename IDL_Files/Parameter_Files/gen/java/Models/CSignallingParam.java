
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CSignallingParam extends CRadioMeasParam
{
    public Integer mParserType;
    public boolean mIsMarking;
    public String mStatus;
    public String mName;
    public Long mSignallingType;
    public short mFilterType;
    public byte[] mMessage;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CSignallingParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mParserType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsMarking)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mStatus)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mSignallingType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mFilterType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteByteArray(mMessage)))
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

            mParserType = parcel.ReadInt32$();
            mIsMarking = parcel.ReadBoolean();
            mStatus = parcel.ReadString();
            mName = parcel.ReadString();
            mSignallingType = parcel.ReadUInt32$();
            mFilterType = parcel.ReadUInt8();
            mMessage = parcel.ReadByteArray();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CSignallingParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mParserType = info.mParserType;
        mIsMarking = info.mIsMarking;
        mStatus = info.mStatus;
        mName = info.mName;
        mSignallingType = info.mSignallingType;
        mFilterType = info.mFilterType;

        if (info.mMessage != null) {
            mMessage = new byte[info.mMessage.length];
            mMessage = info.mMessage.clone();
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mParserType = null;
        mIsMarking = false;
        mStatus = null;
        mName = null;
        mSignallingType = null;
        mFilterType = 0;
        mMessage = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mParserType == null) {
            json = String.format("%s\"mParserType\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mParserType\":\"%s\",", json, mParserType);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mIsMarking\":\"%s\",", json, mIsMarking);
        if (json == null)
            return null;

        if (mStatus == null) {
            json = String.format("%s\"mStatus\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mStatus\":\"%s\",", json, mStatus);
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

        if (mSignallingType == null) {
            json = String.format("%s\"mSignallingType\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSignallingType\":\"%s\",", json, mSignallingType);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mFilterType\":\"%s\",", json, mFilterType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CSignallingParam";
    }
}

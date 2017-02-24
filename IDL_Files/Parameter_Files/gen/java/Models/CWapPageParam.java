
package Models;

import java.math.BigInteger;
import AXP.CParcel;
import AXP.AResult;

public class CWapPageParam extends CRadioMeasParam
{
    public Boolean mIsSuccess;
    public Boolean mIsRefreshSuccess;
    public Integer mIndex;
    public Integer mSuccessCount;
    public Integer mFailCount;
    public Integer mCount;
    public Integer mRefreshSuccessCount;
    public Integer mRefreshFailCount;
    public Integer mRefreshCount;
    public BigInteger mDelay;
    public BigInteger mRefreshDelay;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CWapPageParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean$(mIsSuccess)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean$(mIsRefreshSuccess)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRefreshSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRefreshFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRefreshCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mRefreshDelay)))
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

            mIsSuccess = parcel.ReadBoolean$();
            mIsRefreshSuccess = parcel.ReadBoolean$();
            mIndex = parcel.ReadUInt16$();
            mSuccessCount = parcel.ReadUInt16$();
            mFailCount = parcel.ReadUInt16$();
            mCount = parcel.ReadUInt16$();
            mRefreshSuccessCount = parcel.ReadUInt16$();
            mRefreshFailCount = parcel.ReadUInt16$();
            mRefreshCount = parcel.ReadUInt16$();
            mDelay = parcel.ReadUInt64$();
            mRefreshDelay = parcel.ReadUInt64$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CWapPageParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIsSuccess = info.mIsSuccess;
        mIsRefreshSuccess = info.mIsRefreshSuccess;
        mIndex = info.mIndex;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;
        mRefreshSuccessCount = info.mRefreshSuccessCount;
        mRefreshFailCount = info.mRefreshFailCount;
        mRefreshCount = info.mRefreshCount;
        mDelay = info.mDelay;
        mRefreshDelay = info.mRefreshDelay;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIsSuccess = null;
        mIsRefreshSuccess = null;
        mIndex = null;
        mSuccessCount = null;
        mFailCount = null;
        mCount = null;
        mRefreshSuccessCount = null;
        mRefreshFailCount = null;
        mRefreshCount = null;
        mDelay = null;
        mRefreshDelay = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mIsSuccess == null) {
            json = String.format("%s\"mIsSuccess\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mIsSuccess\":\"%s\",", json, mIsSuccess);
            if (json == null)
                return null;
        }

        if (mIsRefreshSuccess == null) {
            json = String.format("%s\"mIsRefreshSuccess\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mIsRefreshSuccess\":\"%s\",", json, mIsRefreshSuccess);
            if (json == null)
                return null;
        }

        if (mIndex == null) {
            json = String.format("%s\"mIndex\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
            if (json == null)
                return null;
        }

        if (mSuccessCount == null) {
            json = String.format("%s\"mSuccessCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
            if (json == null)
                return null;
        }

        if (mFailCount == null) {
            json = String.format("%s\"mFailCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFailCount\":\"%s\",", json, mFailCount);
            if (json == null)
                return null;
        }

        if (mCount == null) {
            json = String.format("%s\"mCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCount\":\"%s\",", json, mCount);
            if (json == null)
                return null;
        }

        if (mRefreshSuccessCount == null) {
            json = String.format("%s\"mRefreshSuccessCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRefreshSuccessCount\":\"%s\",", json, mRefreshSuccessCount);
            if (json == null)
                return null;
        }

        if (mRefreshFailCount == null) {
            json = String.format("%s\"mRefreshFailCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRefreshFailCount\":\"%s\",", json, mRefreshFailCount);
            if (json == null)
                return null;
        }

        if (mRefreshCount == null) {
            json = String.format("%s\"mRefreshCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRefreshCount\":\"%s\",", json, mRefreshCount);
            if (json == null)
                return null;
        }

        if (mDelay == null) {
            json = String.format("%s\"mDelay\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mDelay\":\"%s\",", json, mDelay);
            if (json == null)
                return null;
        }

        if (mRefreshDelay == null) {
            json = String.format("%s\"mRefreshDelay\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRefreshDelay\":\"%s\"", json, mRefreshDelay);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CWapPageParam";
    }
}

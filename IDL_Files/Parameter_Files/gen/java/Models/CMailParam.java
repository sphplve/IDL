
package Models;

import java.math.BigInteger;
import AXP.CParcel;
import AXP.AResult;

public class CMailParam extends CRadioMeasParam
{
    public Boolean mIsSuccess;
    // 1 send 2 receive
    public Integer mMode;
    public Integer mIndex;
    public BigInteger mDelay;
    public Integer mSuccessCount;
    public Integer mFailCount;
    public Integer mCount;
    public String mMailAddress;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CMailParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean$(mIsSuccess)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMode)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt64$(mDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mMailAddress)))
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
            mMode = parcel.ReadUInt16$();
            mIndex = parcel.ReadUInt16$();
            mDelay = parcel.ReadUInt64$();
            mSuccessCount = parcel.ReadUInt16$();
            mFailCount = parcel.ReadUInt16$();
            mCount = parcel.ReadUInt16$();
            mMailAddress = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CMailParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIsSuccess = info.mIsSuccess;
        mMode = info.mMode;
        mIndex = info.mIndex;
        mDelay = info.mDelay;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;
        mMailAddress = info.mMailAddress;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIsSuccess = null;
        mMode = null;
        mIndex = null;
        mDelay = null;
        mSuccessCount = null;
        mFailCount = null;
        mCount = null;
        mMailAddress = null;
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

        if (mMode == null) {
            json = String.format("%s\"mMode\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMode\":\"%s\",", json, mMode);
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

        if (mMailAddress == null) {
            json = String.format("%s\"mMailAddress\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMailAddress\":\"%s\"", json, mMailAddress);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CMailParam";
    }
}

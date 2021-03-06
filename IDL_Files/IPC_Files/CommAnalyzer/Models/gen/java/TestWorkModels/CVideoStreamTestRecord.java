﻿
package TestWorkModels;

import AXP.CParcel;
import AXP.AResult;

public class CVideoStreamTestRecord extends CTestRecord
{
    public int mIndex;
    public String mUrl;
    public boolean mIsSuccess;
    public long mElapsed;
    public int mSuccessCount;
    public int mFailCount;
    public int mCount;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CVideoStreamTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mUrl)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsSuccess)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mElapsed)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mCount)))
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

            mIndex = parcel.ReadInt32();
            mUrl = parcel.ReadString();
            mIsSuccess = parcel.ReadBoolean();
            mElapsed = parcel.ReadInt64();
            mSuccessCount = parcel.ReadInt32();
            mFailCount = parcel.ReadInt32();
            mCount = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CVideoStreamTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIndex = info.mIndex;
        mUrl = info.mUrl;
        mIsSuccess = info.mIsSuccess;
        mElapsed = info.mElapsed;
        mSuccessCount = info.mSuccessCount;
        mFailCount = info.mFailCount;
        mCount = info.mCount;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIndex = 0;
        mUrl = null;
        mIsSuccess = false;
        mElapsed = 0;
        mSuccessCount = 0;
        mFailCount = 0;
        mCount = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
        if (json == null)
            return null;

        if (mUrl == null) {
            json = String.format("%s\"mUrl\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUrl\":\"%s\",", json, mUrl);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mIsSuccess\":\"%s\",", json, mIsSuccess);
        if (json == null)
            return null;

        json = String.format("%s\"mElapsed\":\"%s\",", json, mElapsed);
        if (json == null)
            return null;

        json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
        if (json == null)
            return null;

        json = String.format("%s\"mFailCount\":\"%s\",", json, mFailCount);
        if (json == null)
            return null;

        json = String.format("%s\"mCount\":\"%s\"", json, mCount);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CVideoStreamTestRecord";
    }
}

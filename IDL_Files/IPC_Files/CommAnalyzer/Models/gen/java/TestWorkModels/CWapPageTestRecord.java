
package TestWorkModels;

import AXP.CParcel;
import AXP.AResult;

public class CWapPageTestRecord extends CTestRecord
{
    public int mIndex;
    public long mLogonElapsed;
    public int mLogonSuccessCount;
    public int mLogonFailCount;
    public int mLogonCount;
    public long mRefreshElapsed;
    public int mRefreshSuccessCount;
    public int mRefreshFailCount;
    public int mRefreshCount;
    public boolean mLogonSuccess;
    public boolean mRefreshSuccess;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CWapPageTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mLogonElapsed)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLogonSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLogonFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mLogonCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mRefreshElapsed)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mRefreshSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mRefreshFailCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mRefreshCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mLogonSuccess)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mRefreshSuccess)))
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
            mLogonElapsed = parcel.ReadInt64();
            mLogonSuccessCount = parcel.ReadInt32();
            mLogonFailCount = parcel.ReadInt32();
            mLogonCount = parcel.ReadInt32();
            mRefreshElapsed = parcel.ReadInt64();
            mRefreshSuccessCount = parcel.ReadInt32();
            mRefreshFailCount = parcel.ReadInt32();
            mRefreshCount = parcel.ReadInt32();
            mLogonSuccess = parcel.ReadBoolean();
            mRefreshSuccess = parcel.ReadBoolean();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CWapPageTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIndex = info.mIndex;
        mLogonElapsed = info.mLogonElapsed;
        mLogonSuccessCount = info.mLogonSuccessCount;
        mLogonFailCount = info.mLogonFailCount;
        mLogonCount = info.mLogonCount;
        mRefreshElapsed = info.mRefreshElapsed;
        mRefreshSuccessCount = info.mRefreshSuccessCount;
        mRefreshFailCount = info.mRefreshFailCount;
        mRefreshCount = info.mRefreshCount;
        mLogonSuccess = info.mLogonSuccess;
        mRefreshSuccess = info.mRefreshSuccess;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIndex = 0;
        mLogonElapsed = 0;
        mLogonSuccessCount = 0;
        mLogonFailCount = 0;
        mLogonCount = 0;
        mRefreshElapsed = 0;
        mRefreshSuccessCount = 0;
        mRefreshFailCount = 0;
        mRefreshCount = 0;
        mLogonSuccess = false;
        mRefreshSuccess = false;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mIndex\":\"%s\",", json, mIndex);
        if (json == null)
            return null;

        json = String.format("%s\"mLogonElapsed\":\"%s\",", json, mLogonElapsed);
        if (json == null)
            return null;

        json = String.format("%s\"mLogonSuccessCount\":\"%s\",", json, mLogonSuccessCount);
        if (json == null)
            return null;

        json = String.format("%s\"mLogonFailCount\":\"%s\",", json, mLogonFailCount);
        if (json == null)
            return null;

        json = String.format("%s\"mLogonCount\":\"%s\",", json, mLogonCount);
        if (json == null)
            return null;

        json = String.format("%s\"mRefreshElapsed\":\"%s\",", json, mRefreshElapsed);
        if (json == null)
            return null;

        json = String.format("%s\"mRefreshSuccessCount\":\"%s\",", json, mRefreshSuccessCount);
        if (json == null)
            return null;

        json = String.format("%s\"mRefreshFailCount\":\"%s\",", json, mRefreshFailCount);
        if (json == null)
            return null;

        json = String.format("%s\"mRefreshCount\":\"%s\",", json, mRefreshCount);
        if (json == null)
            return null;

        json = String.format("%s\"mLogonSuccess\":\"%s\",", json, mLogonSuccess);
        if (json == null)
            return null;

        json = String.format("%s\"mRefreshSuccess\":\"%s\"", json, mRefreshSuccess);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CWapPageTestRecord";
    }
}

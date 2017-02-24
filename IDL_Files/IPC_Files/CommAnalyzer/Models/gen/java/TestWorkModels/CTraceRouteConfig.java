
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTraceRouteConfig implements IParcelable
{
    public int mTestCount;
    public String mTraceHost;
    public int mPackageSize;
    public int mIntervalTime;
    public int mHopTimeOut;
    public int mHopIntervalTime;
    public int mHopDetectTime;
    public int mPppType;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CTraceRouteConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mTraceHost)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPackageSize)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mHopTimeOut)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mHopIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mHopDetectTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTestCount = parcel.ReadInt32();
            mTraceHost = parcel.ReadString();
            mPackageSize = parcel.ReadInt32();
            mIntervalTime = parcel.ReadInt32();
            mHopTimeOut = parcel.ReadInt32();
            mHopIntervalTime = parcel.ReadInt32();
            mHopDetectTime = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTraceRouteConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mTraceHost = info.mTraceHost;
        mPackageSize = info.mPackageSize;
        mIntervalTime = info.mIntervalTime;
        mHopTimeOut = info.mHopTimeOut;
        mHopIntervalTime = info.mHopIntervalTime;
        mHopDetectTime = info.mHopDetectTime;
        mPppType = info.mPppType;

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mTraceHost = null;
        mPackageSize = 0;
        mIntervalTime = 0;
        mHopTimeOut = 0;
        mHopIntervalTime = 0;
        mHopDetectTime = 0;
        mPppType = 0;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        if (mTraceHost == null) {
            json = String.format("%s\"mTraceHost\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mTraceHost\":\"%s\",", json, mTraceHost);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mPackageSize\":\"%s\",", json, mPackageSize);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mHopTimeOut\":\"%s\",", json, mHopTimeOut);
        if (json == null)
            return null;

        json = String.format("%s\"mHopIntervalTime\":\"%s\",", json, mHopIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mHopDetectTime\":\"%s\",", json, mHopDetectTime);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\"", json, mPppType);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CTraceRouteConfig";
    }
}

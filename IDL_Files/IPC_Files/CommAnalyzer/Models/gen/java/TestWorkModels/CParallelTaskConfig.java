
package TestWorkModels;

import java.util.LinkedList;
import java.util.List;
import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CParallelTaskConfig implements IParcelable
{
    public int mTestCount;
    public int mIntervalTime;
    public int mVoiceDelay;
    public int mPppType;
    public List<CTestItem> mTaskItems;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CParallelTaskConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTestCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mIntervalTime)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mVoiceDelay)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mPppType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mTaskItems)))
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
            mIntervalTime = parcel.ReadInt32();
            mVoiceDelay = parcel.ReadInt32();
            mPppType = parcel.ReadInt32();
            mTaskItems = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CParallelTaskConfig info)
    {
        if (info == null)
            return false;

        mTestCount = info.mTestCount;
        mIntervalTime = info.mIntervalTime;
        mVoiceDelay = info.mVoiceDelay;
        mPppType = info.mPppType;

        if (info.mTaskItems != null) {
            if (mTaskItems != null)
                mTaskItems.clear();
            else
                mTaskItems = new LinkedList<CTestItem>();

            for (int i = 0; i < info.mTaskItems.size(); ++i)
                mTaskItems.add(info.mTaskItems.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        mTestCount = 0;
        mIntervalTime = 0;
        mVoiceDelay = 0;
        mPppType = 0;
        if (mTaskItems != null)
            mTaskItems.clear();
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mTestCount\":\"%s\",", json, mTestCount);
        if (json == null)
            return null;

        json = String.format("%s\"mIntervalTime\":\"%s\",", json, mIntervalTime);
        if (json == null)
            return null;

        json = String.format("%s\"mVoiceDelay\":\"%s\",", json, mVoiceDelay);
        if (json == null)
            return null;

        json = String.format("%s\"mPppType\":\"%s\",", json, mPppType);
        if (json == null)
            return null;

        if (mTaskItems == null) {
            json = String.format("%s\"mTaskItems\":[]", json);
            if (json == null)
                return null;
        }
        else {
            String jsonTmp = String.format("\"mTaskItems\":[");
            if (jsonTmp == null)
                return null;

            for(int i = 0; i < mTaskItems.size(); ++i) {
                CTestItem obj = mTaskItems.get(i);
                String comma = null;
                if (i < mTaskItems.size() - 1)
                    comma = ",";
                else
                    comma = "";

                if (obj == null)
                    return null;

                String str = obj.ToString();
                if (str == null)
                    return null;

                jsonTmp = String.format("%s%s%s", jsonTmp, str, comma);
                if (jsonTmp == null)
                    return null;
            }

            jsonTmp = String.format("%s]", jsonTmp);
            if (jsonTmp == null)
                return null;

            json = String.format("%s%s", json, jsonTmp);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CParallelTaskConfig";
    }
}


package TestWorkModels;

import java.util.LinkedList;
import java.util.List;
import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CTaskTemplate implements IParcelable
{
    public String mTaskName;
    public int mTaskType;
    public int mCycleCount;
    public List<CTestItem> mTaskItems;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CTaskTemplate")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mTaskName)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mTaskType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mCycleCount)))
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
            mTaskName = parcel.ReadString();
            mTaskType = parcel.ReadInt32();
            mCycleCount = parcel.ReadInt32();
            mTaskItems = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTaskTemplate info)
    {
        if (info == null)
            return false;

        mTaskName = info.mTaskName;
        mTaskType = info.mTaskType;
        mCycleCount = info.mCycleCount;

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
        mTaskName = null;
        mTaskType = 0;
        mCycleCount = 0;
        if (mTaskItems != null)
            mTaskItems.clear();
    }

    public String ToString()
    {
        String json = "{";
        if (mTaskName == null) {
            json = String.format("%s\"mTaskName\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mTaskName\":\"%s\",", json, mTaskName);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mTaskType\":\"%s\",", json, mTaskType);
        if (json == null)
            return null;

        json = String.format("%s\"mCycleCount\":\"%s\",", json, mCycleCount);
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
        return "TestWorkModels.CTaskTemplate";
    }
}

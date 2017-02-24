
package TestWorkModels;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CHttpTestRecord extends CTestRecord
{
    public double mSpeedAvg;
    public List<CFtpHttpGroupInfo> mGroupInfos;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CHttpTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble(mSpeedAvg)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mGroupInfos)))
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

            mSpeedAvg = parcel.ReadDouble();
            mGroupInfos = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CHttpTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSpeedAvg = info.mSpeedAvg;

        if (info.mGroupInfos != null) {
            if (mGroupInfos != null)
                mGroupInfos.clear();
            else
                mGroupInfos = new LinkedList<CFtpHttpGroupInfo>();

            for (int i = 0; i < info.mGroupInfos.size(); ++i)
                mGroupInfos.add(info.mGroupInfos.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSpeedAvg = 0;
        if (mGroupInfos != null)
            mGroupInfos.clear();
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mSpeedAvg\":\"%s\",", json, mSpeedAvg);
        if (json == null)
            return null;

        if (mGroupInfos == null) {
            json = String.format("%s\"mGroupInfos\":[]", json);
            if (json == null)
                return null;
        }
        else {
            String jsonTmp = String.format("\"mGroupInfos\":[");
            if (jsonTmp == null)
                return null;

            for(int i = 0; i < mGroupInfos.size(); ++i) {
                CFtpHttpGroupInfo obj = mGroupInfos.get(i);
                String comma = null;
                if (i < mGroupInfos.size() - 1)
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
        return "TestWorkModels.CHttpTestRecord";
    }
}

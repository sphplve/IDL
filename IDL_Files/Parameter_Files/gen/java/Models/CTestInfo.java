
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTestInfo implements IParcelable
{
    public Byte mTestType;
    public String mFilePath;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTestInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mTestType)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString(mFilePath)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTestType = parcel.ReadInt8$();
            mFilePath = parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTestInfo info)
    {
        if (info == null)
            return false;

        mTestType = info.mTestType;
        mFilePath = info.mFilePath;

        return true;
    }

    public void SetNull()
    {
        mTestType = null;
        mFilePath = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mTestType == null) {
            json = String.format("%s\"mTestType\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mTestType\":\"%s\",", json, mTestType);
            if (json == null)
                return null;
        }

        if (mFilePath == null) {
            json = String.format("%s\"mFilePath\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mFilePath\":\"%s\"", json, mFilePath);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CTestInfo";
    }
}

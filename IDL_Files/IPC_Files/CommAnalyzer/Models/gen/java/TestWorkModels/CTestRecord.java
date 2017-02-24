
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTestRecord implements IParcelable
{
    public long mTime;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mTime)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTime = parcel.ReadInt64();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTestRecord info)
    {
        if (info == null)
            return false;

        mTime = info.mTime;

        return true;
    }

    public void SetNull()
    {
        mTime = 0;
    }

    public String ToString()
    {
        return String.format("%s", mTime);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CTestRecord";
    }
}

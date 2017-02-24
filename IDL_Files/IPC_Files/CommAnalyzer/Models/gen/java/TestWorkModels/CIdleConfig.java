
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CIdleConfig implements IParcelable
{
    public long mTestTime;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CIdleConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt64(mTestTime)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTestTime = parcel.ReadInt64();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CIdleConfig info)
    {
        if (info == null)
            return false;

        mTestTime = info.mTestTime;

        return true;
    }

    public void SetNull()
    {
        mTestTime = 0;
    }

    public String ToString()
    {
        return String.format("%s", mTestTime);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CIdleConfig";
    }
}

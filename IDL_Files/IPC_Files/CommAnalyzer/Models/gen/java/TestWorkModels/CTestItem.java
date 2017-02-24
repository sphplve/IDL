
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTestItem implements IParcelable
{
    public int mItemIndex;
    public boolean mIsShowButtons;
    public boolean mIsDropDown;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CTestItem")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32(mItemIndex)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsShowButtons)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteBoolean(mIsDropDown)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mItemIndex = parcel.ReadInt32();
            mIsShowButtons = parcel.ReadBoolean();
            mIsDropDown = parcel.ReadBoolean();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTestItem info)
    {
        if (info == null)
            return false;

        mItemIndex = info.mItemIndex;
        mIsShowButtons = info.mIsShowButtons;
        mIsDropDown = info.mIsDropDown;

        return true;
    }

    public void SetNull()
    {
        mItemIndex = 0;
        mIsShowButtons = false;
        mIsDropDown = false;
    }

    public String ToString()
    {
        String json = "{";
        json = String.format("%s\"mItemIndex\":\"%s\",", json, mItemIndex);
        if (json == null)
            return null;

        json = String.format("%s\"mIsShowButtons\":\"%s\",", json, mIsShowButtons);
        if (json == null)
            return null;

        json = String.format("%s\"mIsDropDown\":\"%s\"", json, mIsDropDown);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CTestItem";
    }
}

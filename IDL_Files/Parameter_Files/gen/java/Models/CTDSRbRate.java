
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTDSRbRate implements IParcelable
{
    public Long mRB_ID;
    public Long mDL_RB_Thr;
    public Long mUL_RB_Thr;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRbRate")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mRB_ID)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mDL_RB_Thr)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mUL_RB_Thr)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mRB_ID = parcel.ReadUInt32$();
            mDL_RB_Thr = parcel.ReadUInt32$();
            mUL_RB_Thr = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRbRate info)
    {
        if (info == null)
            return false;

        mRB_ID = info.mRB_ID;
        mDL_RB_Thr = info.mDL_RB_Thr;
        mUL_RB_Thr = info.mUL_RB_Thr;

        return true;
    }

    public void SetNull()
    {
        mRB_ID = null;
        mDL_RB_Thr = null;
        mUL_RB_Thr = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mRB_ID == null) {
            json = String.format("%s\"mRB_ID\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRB_ID\":\"%s\",", json, mRB_ID);
            if (json == null)
                return null;
        }

        if (mDL_RB_Thr == null) {
            json = String.format("%s\"mDL_RB_Thr\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mDL_RB_Thr\":\"%s\",", json, mDL_RB_Thr);
            if (json == null)
                return null;
        }

        if (mUL_RB_Thr == null) {
            json = String.format("%s\"mUL_RB_Thr\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUL_RB_Thr\":\"%s\"", json, mUL_RB_Thr);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRbRate";
    }
}

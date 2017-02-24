
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CGSMNCInfo implements IParcelable
{
    public Integer mBCCH;
    public Integer mBSIC;
    public Byte mRxLev;
    public Integer mC1;
    public Integer mC2;
    public Integer mC31;
    public Integer mC32;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMNCInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBCCH)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBSIC)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mRxLev)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC1)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC2)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC31)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt32$(mC32)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mBCCH = parcel.ReadUInt16$();
            mBSIC = parcel.ReadUInt16$();
            mRxLev = parcel.ReadInt8$();
            mC1 = parcel.ReadInt32$();
            mC2 = parcel.ReadInt32$();
            mC31 = parcel.ReadInt32$();
            mC32 = parcel.ReadInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMNCInfo info)
    {
        if (info == null)
            return false;

        mBCCH = info.mBCCH;
        mBSIC = info.mBSIC;
        mRxLev = info.mRxLev;
        mC1 = info.mC1;
        mC2 = info.mC2;
        mC31 = info.mC31;
        mC32 = info.mC32;

        return true;
    }

    public void SetNull()
    {
        mBCCH = null;
        mBSIC = null;
        mRxLev = null;
        mC1 = null;
        mC2 = null;
        mC31 = null;
        mC32 = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mBCCH == null) {
            json = String.format("%s\"mBCCH\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mBCCH\":\"%s\",", json, mBCCH);
            if (json == null)
                return null;
        }

        if (mBSIC == null) {
            json = String.format("%s\"mBSIC\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mBSIC\":\"%s\",", json, mBSIC);
            if (json == null)
                return null;
        }

        if (mRxLev == null) {
            json = String.format("%s\"mRxLev\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRxLev\":\"%s\",", json, mRxLev);
            if (json == null)
                return null;
        }

        if (mC1 == null) {
            json = String.format("%s\"mC1\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mC1\":\"%s\",", json, mC1);
            if (json == null)
                return null;
        }

        if (mC2 == null) {
            json = String.format("%s\"mC2\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mC2\":\"%s\",", json, mC2);
            if (json == null)
                return null;
        }

        if (mC31 == null) {
            json = String.format("%s\"mC31\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mC31\":\"%s\",", json, mC31);
            if (json == null)
                return null;
        }

        if (mC32 == null) {
            json = String.format("%s\"mC32\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mC32\":\"%s\"", json, mC32);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CGSMNCInfo";
    }
}

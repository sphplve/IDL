
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CLTENCInfo implements IParcelable
{
    public Integer mPCI;
    public Integer mEARFCN;
    public Short mRSRP;
    public Short mRSRQ;
    public Short mRSSI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTENCInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPCI)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mEARFCN)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRSRP)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRSRQ)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRSSI)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mPCI = parcel.ReadUInt16$();
            mEARFCN = parcel.ReadUInt16$();
            mRSRP = parcel.ReadInt16$();
            mRSRQ = parcel.ReadInt16$();
            mRSSI = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTENCInfo info)
    {
        if (info == null)
            return false;

        mPCI = info.mPCI;
        mEARFCN = info.mEARFCN;
        mRSRP = info.mRSRP;
        mRSRQ = info.mRSRQ;
        mRSSI = info.mRSSI;

        return true;
    }

    public void SetNull()
    {
        mPCI = null;
        mEARFCN = null;
        mRSRP = null;
        mRSRQ = null;
        mRSSI = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mPCI == null) {
            json = String.format("%s\"mPCI\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPCI\":\"%s\",", json, mPCI);
            if (json == null)
                return null;
        }

        if (mEARFCN == null) {
            json = String.format("%s\"mEARFCN\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mEARFCN\":\"%s\",", json, mEARFCN);
            if (json == null)
                return null;
        }

        if (mRSRP == null) {
            json = String.format("%s\"mRSRP\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRSRP\":\"%s\",", json, mRSRP);
            if (json == null)
                return null;
        }

        if (mRSRQ == null) {
            json = String.format("%s\"mRSRQ\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRSRQ\":\"%s\",", json, mRSRQ);
            if (json == null)
                return null;
        }

        if (mRSSI == null) {
            json = String.format("%s\"mRSSI\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRSSI\":\"%s\"", json, mRSSI);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CLTENCInfo";
    }
}

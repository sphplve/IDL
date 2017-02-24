
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTDSNCInfo implements IParcelable
{
    public Short mCarrierRSSI;
    public Integer mPathloss;
    public Short mRSCP;
    public Integer mUARFCN;
    public Short mRn;
    public Integer mCPI;
    public Integer mNeighbourSetsCount;
    public short mMidID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSNCInfo")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mCarrierRSSI)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mPathloss)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRSCP)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUARFCN)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRn)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCPI)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mNeighbourSetsCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8(mMidID)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mCarrierRSSI = parcel.ReadInt16$();
            mPathloss = parcel.ReadUInt16$();
            mRSCP = parcel.ReadInt16$();
            mUARFCN = parcel.ReadUInt16$();
            mRn = parcel.ReadInt16$();
            mCPI = parcel.ReadUInt16$();
            mNeighbourSetsCount = parcel.ReadUInt16$();
            mMidID = parcel.ReadUInt8();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSNCInfo info)
    {
        if (info == null)
            return false;

        mCarrierRSSI = info.mCarrierRSSI;
        mPathloss = info.mPathloss;
        mRSCP = info.mRSCP;
        mUARFCN = info.mUARFCN;
        mRn = info.mRn;
        mCPI = info.mCPI;
        mNeighbourSetsCount = info.mNeighbourSetsCount;
        mMidID = info.mMidID;

        return true;
    }

    public void SetNull()
    {
        mCarrierRSSI = null;
        mPathloss = null;
        mRSCP = null;
        mUARFCN = null;
        mRn = null;
        mCPI = null;
        mNeighbourSetsCount = null;
        mMidID = 0;
    }

    public String ToString()
    {
        String json = "{";
        if (mCarrierRSSI == null) {
            json = String.format("%s\"mCarrierRSSI\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCarrierRSSI\":\"%s\",", json, mCarrierRSSI);
            if (json == null)
                return null;
        }

        if (mPathloss == null) {
            json = String.format("%s\"mPathloss\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mPathloss\":\"%s\",", json, mPathloss);
            if (json == null)
                return null;
        }

        if (mRSCP == null) {
            json = String.format("%s\"mRSCP\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRSCP\":\"%s\",", json, mRSCP);
            if (json == null)
                return null;
        }

        if (mUARFCN == null) {
            json = String.format("%s\"mUARFCN\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mUARFCN\":\"%s\",", json, mUARFCN);
            if (json == null)
                return null;
        }

        if (mRn == null) {
            json = String.format("%s\"mRn\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mRn\":\"%s\",", json, mRn);
            if (json == null)
                return null;
        }

        if (mCPI == null) {
            json = String.format("%s\"mCPI\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCPI\":\"%s\",", json, mCPI);
            if (json == null)
                return null;
        }

        if (mNeighbourSetsCount == null) {
            json = String.format("%s\"mNeighbourSetsCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mNeighbourSetsCount\":\"%s\",", json, mNeighbourSetsCount);
            if (json == null)
                return null;
        }

        json = String.format("%s\"mMidID\":\"%s\"", json, mMidID);
        if (json == null)
            return null;

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CTDSNCInfo";
    }
}

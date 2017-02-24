
package Models;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CTDSDL_DPCH_Ts_Info implements IParcelable
{
    public Short mTimeslot;
    public Short mMidamble_Configuration;
    public Short mMidamble_Shift;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSDL_DPCH_Ts_Info")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTimeslot)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMidamble_Configuration)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMidamble_Shift)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            mTimeslot = parcel.ReadUInt8$();
            mMidamble_Configuration = parcel.ReadUInt8$();
            mMidamble_Shift = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSDL_DPCH_Ts_Info info)
    {
        if (info == null)
            return false;

        mTimeslot = info.mTimeslot;
        mMidamble_Configuration = info.mMidamble_Configuration;
        mMidamble_Shift = info.mMidamble_Shift;

        return true;
    }

    public void SetNull()
    {
        mTimeslot = null;
        mMidamble_Configuration = null;
        mMidamble_Shift = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mTimeslot == null) {
            json = String.format("%s\"mTimeslot\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mTimeslot\":\"%s\",", json, mTimeslot);
            if (json == null)
                return null;
        }

        if (mMidamble_Configuration == null) {
            json = String.format("%s\"mMidamble_Configuration\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMidamble_Configuration\":\"%s\",", json, mMidamble_Configuration);
            if (json == null)
                return null;
        }

        if (mMidamble_Shift == null) {
            json = String.format("%s\"mMidamble_Shift\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMidamble_Shift\":\"%s\"", json, mMidamble_Shift);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CTDSDL_DPCH_Ts_Info";
    }
}

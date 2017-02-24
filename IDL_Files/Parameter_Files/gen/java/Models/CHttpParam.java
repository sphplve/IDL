
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CHttpParam extends CRadioMeasParam
{
    public Integer mSuccessCount;
    public Integer mCount;
    public Double mSpeedAvg;
    // 1 up 2 down
    public Integer mMode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CHttpParam")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSuccessCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCount)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mSpeedAvg)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMode)))
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

            mSuccessCount = parcel.ReadUInt16$();
            mCount = parcel.ReadUInt16$();
            mSpeedAvg = parcel.ReadDouble$();
            mMode = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CHttpParam info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSuccessCount = info.mSuccessCount;
        mCount = info.mCount;
        mSpeedAvg = info.mSpeedAvg;
        mMode = info.mMode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSuccessCount = null;
        mCount = null;
        mSpeedAvg = null;
        mMode = null;
    }

    public String ToString()
    {
        String json = "{";
        if (mSuccessCount == null) {
            json = String.format("%s\"mSuccessCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSuccessCount\":\"%s\",", json, mSuccessCount);
            if (json == null)
                return null;
        }

        if (mCount == null) {
            json = String.format("%s\"mCount\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mCount\":\"%s\",", json, mCount);
            if (json == null)
                return null;
        }

        if (mSpeedAvg == null) {
            json = String.format("%s\"mSpeedAvg\":\"\",", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mSpeedAvg\":\"%s\",", json, mSpeedAvg);
            if (json == null)
                return null;
        }

        if (mMode == null) {
            json = String.format("%s\"mMode\":\"\"", json);
            if (json == null)
                return null;
        }
        else {
            json = String.format("%s\"mMode\":\"%s\"", json, mMode);
            if (json == null)
                return null;
        }

        return String.format("%s}", json);
    }

    public String GetTypeName()
    {
        return "Models.CHttpParam";
    }
}


package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CTDSRbRates extends CRadioMeasParam
{
    public List<CTDSRbRate> mRbRates;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSRbRates")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mRbRates)))
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

            mRbRates = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSRbRates info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mRbRates != null) {
            if (mRbRates != null)
                mRbRates.clear();
            else
                mRbRates = new LinkedList<CTDSRbRate>();

            for (int i = 0; i < info.mRbRates.size(); ++i)
                mRbRates.add(info.mRbRates.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mRbRates != null)
            mRbRates.clear();
    }

    public String ToString()
    {
        if (mRbRates == null)
            return null;

        String json = "[";
        for(int i = 0; i < mRbRates.size(); ++i) {
            CTDSRbRate obj = mRbRates.get(i);
            String comma = null;
            if (i < mRbRates.size() - 1)
                comma = ",";
            else
                comma = "";

            if (obj == null)
                return null;

            String str = obj.ToString();
            if (str == null)
                return null;

            json = String.format("%s%s%s", json, str, comma);
            if (json == null)
                return null;
        }

        return String.format("%s]", json);
    }

    public String GetTypeName()
    {
        return "Models.CTDSRbRates";
    }
}

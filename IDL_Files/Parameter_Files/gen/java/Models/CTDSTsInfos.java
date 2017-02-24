
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CTDSTsInfos extends CRadioMeasParam
{
    public List<CTDSDL_DPCH_Ts_Info> mTsInfos;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTsInfos")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mTsInfos)))
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

            mTsInfos = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTsInfos info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mTsInfos != null) {
            if (mTsInfos != null)
                mTsInfos.clear();
            else
                mTsInfos = new LinkedList<CTDSDL_DPCH_Ts_Info>();

            for (int i = 0; i < info.mTsInfos.size(); ++i)
                mTsInfos.add(info.mTsInfos.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mTsInfos != null)
            mTsInfos.clear();
    }

    public String ToString()
    {
        if (mTsInfos == null)
            return null;

        String json = "[";
        for(int i = 0; i < mTsInfos.size(); ++i) {
            CTDSDL_DPCH_Ts_Info obj = mTsInfos.get(i);
            String comma = null;
            if (i < mTsInfos.size() - 1)
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
        return "Models.CTDSTsInfos";
    }
}

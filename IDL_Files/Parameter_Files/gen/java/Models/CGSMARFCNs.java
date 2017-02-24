
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CGSMARFCNs extends CRadioMeasParam
{
    public List<CGSMARFCN> mARFCNs;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMARFCNs")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mARFCNs)))
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

            mARFCNs = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMARFCNs info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mARFCNs != null) {
            if (mARFCNs != null)
                mARFCNs.clear();
            else
                mARFCNs = new LinkedList<CGSMARFCN>();

            for (int i = 0; i < info.mARFCNs.size(); ++i)
                mARFCNs.add(info.mARFCNs.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mARFCNs != null)
            mARFCNs.clear();
    }

    public String ToString()
    {
        if (mARFCNs == null)
            return null;

        String json = "[";
        for(int i = 0; i < mARFCNs.size(); ++i) {
            CGSMARFCN obj = mARFCNs.get(i);
            String comma = null;
            if (i < mARFCNs.size() - 1)
                comma = ",";
            else
                comma = "";

            if (obj == null)
                return null;

            String str = obj.ToString();
            if (str == null)
                return null;

            json = String.format("%s\"%s\"%s", json, str, comma);
            if (json == null)
                return null;
        }

        return String.format("%s]", json);
    }

    public String GetTypeName()
    {
        return "Models.CGSMARFCNs";
    }
}

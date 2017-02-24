
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;
import IPC.java.ObjectParcel;

public class CLTENeighborCellInfos extends CRadioMeasParam
{
    public List<CLTENCInfo> mNeighborCellInfos;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTENeighborCellInfos")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(ObjectParcel.WriteListOfObjectToParcel(parcel, mNeighborCellInfos)))
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

            mNeighborCellInfos = ObjectParcel.ReadListOfObjectFromParcel(parcel);
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTENeighborCellInfos info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mNeighborCellInfos != null) {
            if (mNeighborCellInfos != null)
                mNeighborCellInfos.clear();
            else
                mNeighborCellInfos = new LinkedList<CLTENCInfo>();

            for (int i = 0; i < info.mNeighborCellInfos.size(); ++i)
                mNeighborCellInfos.add(info.mNeighborCellInfos.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mNeighborCellInfos != null)
            mNeighborCellInfos.clear();
    }

    public String ToString()
    {
        if (mNeighborCellInfos == null)
            return null;

        String json = "[";
        for(int i = 0; i < mNeighborCellInfos.size(); ++i) {
            CLTENCInfo obj = mNeighborCellInfos.get(i);
            String comma = null;
            if (i < mNeighborCellInfos.size() - 1)
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
        return "Models.CLTENeighborCellInfos";
    }
}

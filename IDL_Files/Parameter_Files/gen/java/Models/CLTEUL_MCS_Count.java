
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;

public class CLTEUL_MCS_Count extends CRadioMeasParam
{
    public List<Integer> mUL_MCS_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUL_MCS_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (mUL_MCS_Count == null) {
            if (AResult.AFAILED(parcel.WriteInt32(0)))
                return AResult.AE_FAIL;
        }
        else {
            if (AResult.AFAILED(parcel.WriteInt32(mUL_MCS_Count.size())))
                return AResult.AE_FAIL;

            for (Integer obj: mUL_MCS_Count) {
                if (AResult.AFAILED(parcel.WriteUInt16$(obj)))
                    return AResult.AE_FAIL;
            }
        }

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

            {
                int count = parcel.ReadInt32();
                if (count == 0)
                    mUL_MCS_Count = null;
                else {
                    mUL_MCS_Count = new LinkedList<Integer>();

                    for (int i = 0; i < count; ++i) {
                        Integer obj = parcel.ReadUInt16$();
                        if (obj == null)
                            return AResult.AE_FAIL;

                        if (!mUL_MCS_Count.add(obj))
                            return AResult.AE_FAIL;
                    }
                }
            }

        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUL_MCS_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mUL_MCS_Count != null) {
            if (mUL_MCS_Count != null)
                mUL_MCS_Count.clear();
            else
                mUL_MCS_Count = new LinkedList<Integer>();

            for (int i = 0; i < info.mUL_MCS_Count.size(); ++i)
                mUL_MCS_Count.add(info.mUL_MCS_Count.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mUL_MCS_Count != null)
            mUL_MCS_Count.clear();
    }

    public String ToString()
    {
        if (mUL_MCS_Count == null)
            return null;

        String json = "[";
        for(int i = 0; i < mUL_MCS_Count.size(); ++i) {
            Integer obj = mUL_MCS_Count.get(i);
            String comma = null;
            if (i < mUL_MCS_Count.size() - 1)
                comma = ",";
            else
                comma = "";

            json = String.format("%s\"%s\"%s", json, obj, comma);
            if (json == null)
                return null;
        }

        return String.format("%s]", json);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUL_MCS_Count";
    }
}

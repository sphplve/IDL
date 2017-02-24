
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_MCS_Code1_Count extends CRadioMeasParam
{
    public List<Integer> mDL_MCS_Code1_Count;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_MCS_Code1_Count")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (mDL_MCS_Code1_Count == null) {
            if (AResult.AFAILED(parcel.WriteInt32(0)))
                return AResult.AE_FAIL;
        }
        else {
            if (AResult.AFAILED(parcel.WriteInt32(mDL_MCS_Code1_Count.size())))
                return AResult.AE_FAIL;

            for (Integer obj: mDL_MCS_Code1_Count) {
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
                    mDL_MCS_Code1_Count = null;
                else {
                    mDL_MCS_Code1_Count = new LinkedList<Integer>();

                    for (int i = 0; i < count; ++i) {
                        Integer obj = parcel.ReadUInt16$();
                        if (obj == null)
                            return AResult.AE_FAIL;

                        if (!mDL_MCS_Code1_Count.add(obj))
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

    public Boolean Copy(CLTEDL_MCS_Code1_Count info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mDL_MCS_Code1_Count != null) {
            if (mDL_MCS_Code1_Count != null)
                mDL_MCS_Code1_Count.clear();
            else
                mDL_MCS_Code1_Count = new LinkedList<Integer>();

            for (int i = 0; i < info.mDL_MCS_Code1_Count.size(); ++i)
                mDL_MCS_Code1_Count.add(info.mDL_MCS_Code1_Count.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mDL_MCS_Code1_Count != null)
            mDL_MCS_Code1_Count.clear();
    }

    public String ToString()
    {
        if (mDL_MCS_Code1_Count == null)
            return null;

        String json = "[";
        for(int i = 0; i < mDL_MCS_Code1_Count.size(); ++i) {
            Integer obj = mDL_MCS_Code1_Count.get(i);
            String comma = null;
            if (i < mDL_MCS_Code1_Count.size() - 1)
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
        return "Models.CLTEDL_MCS_Code1_Count";
    }
}

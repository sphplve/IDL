
package Models;

import java.util.LinkedList;
import java.util.List;
import AXP.CParcel;
import AXP.AResult;

public class CLTEPDCCH_DCI_format extends CRadioMeasParam
{
    public List<Integer> mPDCCH_DCI_format;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPDCCH_DCI_format")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (mPDCCH_DCI_format == null) {
            if (AResult.AFAILED(parcel.WriteInt32(0)))
                return AResult.AE_FAIL;
        }
        else {
            if (AResult.AFAILED(parcel.WriteInt32(mPDCCH_DCI_format.size())))
                return AResult.AE_FAIL;

            for (Integer obj: mPDCCH_DCI_format) {
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
                    mPDCCH_DCI_format = null;
                else {
                    mPDCCH_DCI_format = new LinkedList<Integer>();

                    for (int i = 0; i < count; ++i) {
                        Integer obj = parcel.ReadUInt16$();
                        if (obj == null)
                            return AResult.AE_FAIL;

                        if (!mPDCCH_DCI_format.add(obj))
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

    public Boolean Copy(CLTEPDCCH_DCI_format info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        if (info.mPDCCH_DCI_format != null) {
            if (mPDCCH_DCI_format != null)
                mPDCCH_DCI_format.clear();
            else
                mPDCCH_DCI_format = new LinkedList<Integer>();

            for (int i = 0; i < info.mPDCCH_DCI_format.size(); ++i)
                mPDCCH_DCI_format.add(info.mPDCCH_DCI_format.get(i));
        }

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        if (mPDCCH_DCI_format != null)
            mPDCCH_DCI_format.clear();
    }

    public String ToString()
    {
        if (mPDCCH_DCI_format == null)
            return null;

        String json = "[";
        for(int i = 0; i < mPDCCH_DCI_format.size(); ++i) {
            Integer obj = mPDCCH_DCI_format.get(i);
            String comma = null;
            if (i < mPDCCH_DCI_format.size() - 1)
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
        return "Models.CLTEPDCCH_DCI_format";
    }
}

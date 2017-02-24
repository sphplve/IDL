
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEUECategory extends CRadioMeasParam
{
    public Integer mUECategory;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEUECategory")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mUECategory)))
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

            mUECategory = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEUECategory info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mUECategory = info.mUECategory;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mUECategory = null;
    }

    public String ToString()
    {
        if (mUECategory == null)
            return "";
        else
            return String.format("%s", mUECategory);
    }

    public String GetTypeName()
    {
        return "Models.CLTEUECategory";
    }
}

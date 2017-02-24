
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSInterSearch extends CRadioMeasParam
{
    public Byte mInterSearch;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSInterSearch")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mInterSearch)))
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

            mInterSearch = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSInterSearch info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mInterSearch = info.mInterSearch;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mInterSearch = null;
    }

    public String ToString()
    {
        if (mInterSearch == null)
            return "";
        else
            return String.format("%s", mInterSearch);
    }

    public String GetTypeName()
    {
        return "Models.CTDSInterSearch";
    }
}

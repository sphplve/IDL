
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSIntraSearch extends CRadioMeasParam
{
    public Byte mIntraSearch;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSIntraSearch")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mIntraSearch)))
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

            mIntraSearch = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSIntraSearch info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mIntraSearch = info.mIntraSearch;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mIntraSearch = null;
    }

    public String ToString()
    {
        if (mIntraSearch == null)
            return "";
        else
            return String.format("%s", mIntraSearch);
    }

    public String GetTypeName()
    {
        return "Models.CTDSIntraSearch";
    }
}

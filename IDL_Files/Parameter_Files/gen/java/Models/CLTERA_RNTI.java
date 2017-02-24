
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERA_RNTI extends CRadioMeasParam
{
    public Integer mRA_RNTI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERA_RNTI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRA_RNTI)))
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

            mRA_RNTI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERA_RNTI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRA_RNTI = info.mRA_RNTI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRA_RNTI = null;
    }

    public String ToString()
    {
        if (mRA_RNTI == null)
            return "";
        else
            return String.format("%s", mRA_RNTI);
    }

    public String GetTypeName()
    {
        return "Models.CLTERA_RNTI";
    }
}

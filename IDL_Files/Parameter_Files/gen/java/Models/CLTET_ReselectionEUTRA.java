
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTET_ReselectionEUTRA extends CRadioMeasParam
{
    public Integer mT_ReselectionEUTRA;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTET_ReselectionEUTRA")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mT_ReselectionEUTRA)))
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

            mT_ReselectionEUTRA = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTET_ReselectionEUTRA info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mT_ReselectionEUTRA = info.mT_ReselectionEUTRA;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mT_ReselectionEUTRA = null;
    }

    public String ToString()
    {
        if (mT_ReselectionEUTRA == null)
            return "";
        else
            return String.format("%s", mT_ReselectionEUTRA);
    }

    public String GetTypeName()
    {
        return "Models.CLTET_ReselectionEUTRA";
    }
}

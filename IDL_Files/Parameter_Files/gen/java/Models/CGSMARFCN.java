
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMARFCN extends CRadioMeasParam
{
    public Integer mARFCN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMARFCN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mARFCN)))
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

            mARFCN = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMARFCN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mARFCN = info.mARFCN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mARFCN = null;
    }

    public String ToString()
    {
        if (mARFCN == null)
            return "";
        else
            return String.format("%s", mARFCN);
    }

    public String GetTypeName()
    {
        return "Models.CGSMARFCN";
    }
}

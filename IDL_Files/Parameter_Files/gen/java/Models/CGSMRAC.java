
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRAC extends CRadioMeasParam
{
    public Short mRAC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRAC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRAC)))
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

            mRAC = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRAC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRAC = info.mRAC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRAC = null;
    }

    public String ToString()
    {
        if (mRAC == null)
            return "";
        else
            return String.format("%s", mRAC);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRAC";
    }
}

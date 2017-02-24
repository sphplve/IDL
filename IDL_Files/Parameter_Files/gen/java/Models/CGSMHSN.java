
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMHSN extends CRadioMeasParam
{
    public Short mHSN;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMHSN")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mHSN)))
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

            mHSN = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMHSN info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mHSN = info.mHSN;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mHSN = null;
    }

    public String ToString()
    {
        if (mHSN == null)
            return "";
        else
            return String.format("%s", mHSN);
    }

    public String GetTypeName()
    {
        return "Models.CGSMHSN";
    }
}

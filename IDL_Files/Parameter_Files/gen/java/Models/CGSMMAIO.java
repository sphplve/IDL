
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMMAIO extends CRadioMeasParam
{
    public Short mMAIO;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMMAIO")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMAIO)))
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

            mMAIO = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMMAIO info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMAIO = info.mMAIO;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMAIO = null;
    }

    public String ToString()
    {
        if (mMAIO == null)
            return "";
        else
            return String.format("%s", mMAIO);
    }

    public String GetTypeName()
    {
        return "Models.CGSMMAIO";
    }
}

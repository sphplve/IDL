
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDTX extends CRadioMeasParam
{
    public Short mDTX;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDTX")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDTX)))
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

            mDTX = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDTX info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDTX = info.mDTX;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDTX = null;
    }

    public String ToString()
    {
        if (mDTX == null)
            return "";
        else
            return String.format("%s", mDTX);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDTX";
    }
}

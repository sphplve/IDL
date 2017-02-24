
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSCellBarred extends CRadioMeasParam
{
    public Short mCellBarred;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSCellBarred")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCellBarred)))
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

            mCellBarred = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSCellBarred info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCellBarred = info.mCellBarred;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCellBarred = null;
    }

    public String ToString()
    {
        if (mCellBarred == null)
            return "";
        else
            return String.format("%s", mCellBarred);
    }

    public String GetTypeName()
    {
        return "Models.CTDSCellBarred";
    }
}

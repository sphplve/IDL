
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMDL_TS7 extends CRadioMeasParam
{
    public Short mDL_TS7;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMDL_TS7")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDL_TS7)))
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

            mDL_TS7 = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMDL_TS7 info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_TS7 = info.mDL_TS7;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_TS7 = null;
    }

    public String ToString()
    {
        if (mDL_TS7 == null)
            return "";
        else
            return String.format("%s", mDL_TS7);
    }

    public String GetTypeName()
    {
        return "Models.CGSMDL_TS7";
    }
}

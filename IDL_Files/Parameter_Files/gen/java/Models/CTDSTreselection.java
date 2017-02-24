
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSTreselection extends CRadioMeasParam
{
    public Short mTreselection;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSTreselection")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mTreselection)))
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

            mTreselection = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSTreselection info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTreselection = info.mTreselection;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTreselection = null;
    }

    public String ToString()
    {
        if (mTreselection == null)
            return "";
        else
            return String.format("%s", mTreselection);
    }

    public String GetTypeName()
    {
        return "Models.CTDSTreselection";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDrxCfgInd extends CRadioMeasParam
{
    public Short mDrxCfgInd;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDrxCfgInd")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDrxCfgInd)))
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

            mDrxCfgInd = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDrxCfgInd info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDrxCfgInd = info.mDrxCfgInd;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDrxCfgInd = null;
    }

    public String ToString()
    {
        if (mDrxCfgInd == null)
            return "";
        else
            return String.format("%s", mDrxCfgInd);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDrxCfgInd";
    }
}

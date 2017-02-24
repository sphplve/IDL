
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_64QAM extends CRadioMeasParam
{
    public Double mDL_64QAM;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_64QAM")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_64QAM)))
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

            mDL_64QAM = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_64QAM info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_64QAM = info.mDL_64QAM;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_64QAM = null;
    }

    public String ToString()
    {
        if (mDL_64QAM == null)
            return "";
        else
            return String.format("%s", mDL_64QAM);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_64QAM";
    }
}

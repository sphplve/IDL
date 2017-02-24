
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDL_16QAM extends CRadioMeasParam
{
    public Double mDL_16QAM;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDL_16QAM")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDL_16QAM)))
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

            mDL_16QAM = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDL_16QAM info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDL_16QAM = info.mDL_16QAM;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDL_16QAM = null;
    }

    public String ToString()
    {
        if (mDL_16QAM == null)
            return "";
        else
            return String.format("%s", mDL_16QAM);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDL_16QAM";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESRSRBNum extends CRadioMeasParam
{
    public Long mSRSRBNum;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESRSRBNum")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt32$(mSRSRBNum)))
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

            mSRSRBNum = parcel.ReadUInt32$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESRSRBNum info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSRSRBNum = info.mSRSRBNum;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSRSRBNum = null;
    }

    public String ToString()
    {
        if (mSRSRBNum == null)
            return "";
        else
            return String.format("%s", mSRSRBNum);
    }

    public String GetTypeName()
    {
        return "Models.CLTESRSRBNum";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTETCRNTI extends CRadioMeasParam
{
    public Integer mTCRNTI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTETCRNTI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTCRNTI)))
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

            mTCRNTI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTETCRNTI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTCRNTI = info.mTCRNTI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTCRNTI = null;
    }

    public String ToString()
    {
        if (mTCRNTI == null)
            return "";
        else
            return String.format("%s", mTCRNTI);
    }

    public String GetTypeName()
    {
        return "Models.CLTETCRNTI";
    }
}

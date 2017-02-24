
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECRNTI extends CRadioMeasParam
{
    public Integer mCRNTI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECRNTI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mCRNTI)))
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

            mCRNTI = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECRNTI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCRNTI = info.mCRNTI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCRNTI = null;
    }

    public String ToString()
    {
        if (mCRNTI == null)
            return "";
        else
            return String.format("%s", mCRNTI);
    }

    public String GetTypeName()
    {
        return "Models.CLTECRNTI";
    }
}

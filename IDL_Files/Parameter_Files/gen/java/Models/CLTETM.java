
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTETM extends CRadioMeasParam
{
    public Integer mTM;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTETM")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mTM)))
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

            mTM = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTETM info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mTM = info.mTM;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mTM = null;
    }

    public String ToString()
    {
        if (mTM == null)
            return "";
        else
            return String.format("%s", mTM);
    }

    public String GetTypeName()
    {
        return "Models.CLTETM";
    }
}

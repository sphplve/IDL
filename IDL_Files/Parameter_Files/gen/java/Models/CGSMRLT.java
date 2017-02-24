
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRLT extends CRadioMeasParam
{
    public Integer mRLT;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRLT")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mRLT)))
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

            mRLT = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRLT info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRLT = info.mRLT;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRLT = null;
    }

    public String ToString()
    {
        if (mRLT == null)
            return "";
        else
            return String.format("%s", mRLT);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRLT";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMCC extends CRadioMeasParam
{
    public Integer mMCC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMCC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMCC)))
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

            mMCC = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMCC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMCC = info.mMCC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMCC = null;
    }

    public String ToString()
    {
        if (mMCC == null)
            return "";
        else
            return String.format("%s", mMCC);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMCC";
    }
}

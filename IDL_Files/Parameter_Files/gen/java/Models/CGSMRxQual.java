
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMRxQual extends CRadioMeasParam
{
    public Short mRxQual;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMRxQual")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt16$(mRxQual)))
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

            mRxQual = parcel.ReadInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMRxQual info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRxQual = info.mRxQual;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRxQual = null;
    }

    public String ToString()
    {
        if (mRxQual == null)
            return "";
        else
            return String.format("%s", mRxQual);
    }

    public String GetTypeName()
    {
        return "Models.CGSMRxQual";
    }
}

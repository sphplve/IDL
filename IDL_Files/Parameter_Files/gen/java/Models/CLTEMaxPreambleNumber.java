
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMaxPreambleNumber extends CRadioMeasParam
{
    public Short mMaxPreambleNumber;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMaxPreambleNumber")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mMaxPreambleNumber)))
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

            mMaxPreambleNumber = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMaxPreambleNumber info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMaxPreambleNumber = info.mMaxPreambleNumber;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMaxPreambleNumber = null;
    }

    public String ToString()
    {
        if (mMaxPreambleNumber == null)
            return "";
        else
            return String.format("%s", mMaxPreambleNumber);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMaxPreambleNumber";
    }
}

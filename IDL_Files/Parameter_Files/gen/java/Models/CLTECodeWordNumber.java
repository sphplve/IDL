
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTECodeWordNumber extends CRadioMeasParam
{
    public Short mCodeWordNumber;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTECodeWordNumber")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCodeWordNumber)))
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

            mCodeWordNumber = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTECodeWordNumber info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCodeWordNumber = info.mCodeWordNumber;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCodeWordNumber = null;
    }

    public String ToString()
    {
        if (mCodeWordNumber == null)
            return "";
        else
            return String.format("%s", mCodeWordNumber);
    }

    public String GetTypeName()
    {
        return "Models.CLTECodeWordNumber";
    }
}

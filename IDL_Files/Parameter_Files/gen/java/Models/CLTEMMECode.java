
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMMECode extends CRadioMeasParam
{
    public Integer mMMECode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMMECode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMMECode)))
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

            mMMECode = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMMECode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMMECode = info.mMMECode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMMECode = null;
    }

    public String ToString()
    {
        if (mMMECode == null)
            return "";
        else
            return String.format("%s", mMMECode);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMMECode";
    }
}

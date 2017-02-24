
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEPrachConfig extends CRadioMeasParam
{
    public Short mPrachConfig;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEPrachConfig")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPrachConfig)))
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

            mPrachConfig = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEPrachConfig info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPrachConfig = info.mPrachConfig;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPrachConfig = null;
    }

    public String ToString()
    {
        if (mPrachConfig == null)
            return "";
        else
            return String.format("%s", mPrachConfig);
    }

    public String GetTypeName()
    {
        return "Models.CLTEPrachConfig";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMIMO_mode extends CRadioMeasParam
{
    public Integer mMIMO_mode;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMIMO_mode")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMIMO_mode)))
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

            mMIMO_mode = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMIMO_mode info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMIMO_mode = info.mMIMO_mode;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMIMO_mode = null;
    }

    public String ToString()
    {
        if (mMIMO_mode == null)
            return "";
        else
            return String.format("%s", mMIMO_mode);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMIMO_mode";
    }
}

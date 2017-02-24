
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTERRCConnectionReqCause extends CRadioMeasParam
{
    public Short mRRCConnectionReqCause;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTERRCConnectionReqCause")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRRCConnectionReqCause)))
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

            mRRCConnectionReqCause = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTERRCConnectionReqCause info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRRCConnectionReqCause = info.mRRCConnectionReqCause;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRRCConnectionReqCause = null;
    }

    public String ToString()
    {
        if (mRRCConnectionReqCause == null)
            return "";
        else
            return String.format("%s", mRRCConnectionReqCause);
    }

    public String GetTypeName()
    {
        return "Models.CLTERRCConnectionReqCause";
    }
}

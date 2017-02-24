
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEFrameNumber extends CRadioMeasParam
{
    public Integer mFrameNumber;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEFrameNumber")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mFrameNumber)))
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

            mFrameNumber = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEFrameNumber info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mFrameNumber = info.mFrameNumber;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mFrameNumber = null;
    }

    public String ToString()
    {
        if (mFrameNumber == null)
            return "";
        else
            return String.format("%s", mFrameNumber);
    }

    public String GetTypeName()
    {
        return "Models.CLTEFrameNumber";
    }
}

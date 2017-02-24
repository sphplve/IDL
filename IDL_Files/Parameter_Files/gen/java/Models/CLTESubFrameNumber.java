
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTESubFrameNumber extends CRadioMeasParam
{
    public Integer mSubFrameNumber;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTESubFrameNumber")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mSubFrameNumber)))
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

            mSubFrameNumber = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTESubFrameNumber info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSubFrameNumber = info.mSubFrameNumber;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSubFrameNumber = null;
    }

    public String ToString()
    {
        if (mSubFrameNumber == null)
            return "";
        else
            return String.format("%s", mSubFrameNumber);
    }

    public String GetTypeName()
    {
        return "Models.CLTESubFrameNumber";
    }
}

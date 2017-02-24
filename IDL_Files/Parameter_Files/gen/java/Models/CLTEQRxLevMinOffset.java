
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEQRxLevMinOffset extends CRadioMeasParam
{
    public Integer mQRxLevMinOffset;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEQRxLevMinOffset")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mQRxLevMinOffset)))
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

            mQRxLevMinOffset = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEQRxLevMinOffset info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQRxLevMinOffset = info.mQRxLevMinOffset;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQRxLevMinOffset = null;
    }

    public String ToString()
    {
        if (mQRxLevMinOffset == null)
            return "";
        else
            return String.format("%s", mQRxLevMinOffset);
    }

    public String GetTypeName()
    {
        return "Models.CLTEQRxLevMinOffset";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDRXState extends CRadioMeasParam
{
    public Short mDRXState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDRXState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mDRXState)))
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

            mDRXState = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDRXState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDRXState = info.mDRXState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDRXState = null;
    }

    public String ToString()
    {
        if (mDRXState == null)
            return "";
        else
            return String.format("%s", mDRXState);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDRXState";
    }
}

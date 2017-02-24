
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTENetWorkState extends CRadioMeasParam
{
    public Short mNetWorkState;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTENetWorkState")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mNetWorkState)))
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

            mNetWorkState = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTENetWorkState info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mNetWorkState = info.mNetWorkState;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mNetWorkState = null;
    }

    public String ToString()
    {
        if (mNetWorkState == null)
            return "";
        else
            return String.format("%s", mNetWorkState);
    }

    public String GetTypeName()
    {
        return "Models.CLTENetWorkState";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEAllowedMeasBandwidth extends CRadioMeasParam
{
    public Integer mAllowedMeasBandwidth;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEAllowedMeasBandwidth")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mAllowedMeasBandwidth)))
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

            mAllowedMeasBandwidth = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEAllowedMeasBandwidth info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAllowedMeasBandwidth = info.mAllowedMeasBandwidth;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAllowedMeasBandwidth = null;
    }

    public String ToString()
    {
        if (mAllowedMeasBandwidth == null)
            return "";
        else
            return String.format("%s", mAllowedMeasBandwidth);
    }

    public String GetTypeName()
    {
        return "Models.CLTEAllowedMeasBandwidth";
    }
}

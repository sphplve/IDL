
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEWideBandCQI extends CRadioMeasParam
{
    public Short mWideBandCQI;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEWideBandCQI")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mWideBandCQI)))
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

            mWideBandCQI = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEWideBandCQI info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mWideBandCQI = info.mWideBandCQI;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mWideBandCQI = null;
    }

    public String ToString()
    {
        if (mWideBandCQI == null)
            return "";
        else
            return String.format("%s", mWideBandCQI);
    }

    public String GetTypeName()
    {
        return "Models.CLTEWideBandCQI";
    }
}

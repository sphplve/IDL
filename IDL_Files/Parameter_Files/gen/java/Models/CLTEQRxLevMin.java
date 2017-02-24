
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEQRxLevMin extends CRadioMeasParam
{
    public Byte mQRxLevMin;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEQRxLevMin")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteInt8$(mQRxLevMin)))
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

            mQRxLevMin = parcel.ReadInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEQRxLevMin info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQRxLevMin = info.mQRxLevMin;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQRxLevMin = null;
    }

    public String ToString()
    {
        if (mQRxLevMin == null)
            return "";
        else
            return String.format("%s", mQRxLevMin);
    }

    public String GetTypeName()
    {
        return "Models.CLTEQRxLevMin";
    }
}

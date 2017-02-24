
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMAGBLK extends CRadioMeasParam
{
    public Short mAGBLK;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMAGBLK")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mAGBLK)))
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

            mAGBLK = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMAGBLK info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mAGBLK = info.mAGBLK;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mAGBLK = null;
    }

    public String ToString()
    {
        if (mAGBLK == null)
            return "";
        else
            return String.format("%s", mAGBLK);
    }

    public String GetTypeName()
    {
        return "Models.CGSMAGBLK";
    }
}

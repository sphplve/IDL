
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMCell_Barred extends CRadioMeasParam
{
    public Short mCell_Barred;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMCell_Barred")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mCell_Barred)))
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

            mCell_Barred = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMCell_Barred info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mCell_Barred = info.mCell_Barred;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mCell_Barred = null;
    }

    public String ToString()
    {
        if (mCell_Barred == null)
            return "";
        else
            return String.format("%s", mCell_Barred);
    }

    public String GetTypeName()
    {
        return "Models.CGSMCell_Barred";
    }
}

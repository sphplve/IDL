
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMBSIC extends CRadioMeasParam
{
    public Integer mBSIC;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMBSIC")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mBSIC)))
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

            mBSIC = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMBSIC info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mBSIC = info.mBSIC;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mBSIC = null;
    }

    public String ToString()
    {
        if (mBSIC == null)
            return "";
        else
            return String.format("%s", mBSIC);
    }

    public String GetTypeName()
    {
        return "Models.CGSMBSIC";
    }
}

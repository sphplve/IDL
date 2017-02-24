
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSSyncID extends CRadioMeasParam
{
    public Short mSyncID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSSyncID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSyncID)))
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

            mSyncID = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSSyncID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSyncID = info.mSyncID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSyncID = null;
    }

    public String ToString()
    {
        if (mSyncID == null)
            return "";
        else
            return String.format("%s", mSyncID);
    }

    public String GetTypeName()
    {
        return "Models.CTDSSyncID";
    }
}

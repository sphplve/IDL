
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CNASRouting_Area_Update_Request_Type extends CRadioMeasParam
{
    public Short mRouting_Area_Update_Request_Type;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CNASRouting_Area_Update_Request_Type")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mRouting_Area_Update_Request_Type)))
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

            mRouting_Area_Update_Request_Type = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CNASRouting_Area_Update_Request_Type info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mRouting_Area_Update_Request_Type = info.mRouting_Area_Update_Request_Type;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mRouting_Area_Update_Request_Type = null;
    }

    public String ToString()
    {
        if (mRouting_Area_Update_Request_Type == null)
            return "";
        else
            return String.format("%s", mRouting_Area_Update_Request_Type);
    }

    public String GetTypeName()
    {
        return "Models.CNASRouting_Area_Update_Request_Type";
    }
}

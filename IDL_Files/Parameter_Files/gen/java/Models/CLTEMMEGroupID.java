
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEMMEGroupID extends CRadioMeasParam
{
    public Integer mMMEGroupID;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEMMEGroupID")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mMMEGroupID)))
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

            mMMEGroupID = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEMMEGroupID info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mMMEGroupID = info.mMMEGroupID;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mMMEGroupID = null;
    }

    public String ToString()
    {
        if (mMMEGroupID == null)
            return "";
        else
            return String.format("%s", mMMEGroupID);
    }

    public String GetTypeName()
    {
        return "Models.CLTEMMEGroupID";
    }
}

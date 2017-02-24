
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMModulationDL extends CRadioMeasParam
{
    public Integer mModulationDL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMModulationDL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mModulationDL)))
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

            mModulationDL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMModulationDL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mModulationDL = info.mModulationDL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mModulationDL = null;
    }

    public String ToString()
    {
        if (mModulationDL == null)
            return "";
        else
            return String.format("%s", mModulationDL);
    }

    public String GetTypeName()
    {
        return "Models.CGSMModulationDL";
    }
}

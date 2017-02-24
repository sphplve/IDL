
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMModulationUL extends CRadioMeasParam
{
    public Integer mModulationUL;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMModulationUL")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mModulationUL)))
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

            mModulationUL = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMModulationUL info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mModulationUL = info.mModulationUL;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mModulationUL = null;
    }

    public String ToString()
    {
        if (mModulationUL == null)
            return "";
        else
            return String.format("%s", mModulationUL);
    }

    public String GetTypeName()
    {
        return "Models.CGSMModulationUL";
    }
}

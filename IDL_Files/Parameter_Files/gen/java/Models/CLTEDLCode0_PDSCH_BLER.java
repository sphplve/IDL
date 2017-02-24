
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEDLCode0_PDSCH_BLER extends CRadioMeasParam
{
    public Double mDLCode0_PDSCH_BLER;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEDLCode0_PDSCH_BLER")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble$(mDLCode0_PDSCH_BLER)))
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

            mDLCode0_PDSCH_BLER = parcel.ReadDouble$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEDLCode0_PDSCH_BLER info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mDLCode0_PDSCH_BLER = info.mDLCode0_PDSCH_BLER;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mDLCode0_PDSCH_BLER = null;
    }

    public String ToString()
    {
        if (mDLCode0_PDSCH_BLER == null)
            return "";
        else
            return String.format("%s", mDLCode0_PDSCH_BLER);
    }

    public String GetTypeName()
    {
        return "Models.CLTEDLCode0_PDSCH_BLER";
    }
}

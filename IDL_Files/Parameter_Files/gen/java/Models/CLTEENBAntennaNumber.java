
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEENBAntennaNumber extends CRadioMeasParam
{
    public Short mENBAntennaNumber;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEENBAntennaNumber")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mENBAntennaNumber)))
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

            mENBAntennaNumber = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEENBAntennaNumber info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mENBAntennaNumber = info.mENBAntennaNumber;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mENBAntennaNumber = null;
    }

    public String ToString()
    {
        if (mENBAntennaNumber == null)
            return "";
        else
            return String.format("%s", mENBAntennaNumber);
    }

    public String GetTypeName()
    {
        return "Models.CLTEENBAntennaNumber";
    }
}

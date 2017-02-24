
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CTDSPI_Bit_Length extends CRadioMeasParam
{
    public Short mPI_Bit_Length;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CTDSPI_Bit_Length")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mPI_Bit_Length)))
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

            mPI_Bit_Length = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CTDSPI_Bit_Length info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mPI_Bit_Length = info.mPI_Bit_Length;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mPI_Bit_Length = null;
    }

    public String ToString()
    {
        if (mPI_Bit_Length == null)
            return "";
        else
            return String.format("%s", mPI_Bit_Length);
    }

    public String GetTypeName()
    {
        return "Models.CTDSPI_Bit_Length";
    }
}

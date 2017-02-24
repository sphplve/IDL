
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMSNDCP_data_compression extends CRadioMeasParam
{
    public Short mSNDCP_data_compression;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMSNDCP_data_compression")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSNDCP_data_compression)))
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

            mSNDCP_data_compression = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMSNDCP_data_compression info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSNDCP_data_compression = info.mSNDCP_data_compression;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSNDCP_data_compression = null;
    }

    public String ToString()
    {
        if (mSNDCP_data_compression == null)
            return "";
        else
            return String.format("%s", mSNDCP_data_compression);
    }

    public String GetTypeName()
    {
        return "Models.CGSMSNDCP_data_compression";
    }
}


package Models;

import AXP.CParcel;
import AXP.AResult;

public class CGSMSNDCP_header_compression extends CRadioMeasParam
{
    public Short mSNDCP_header_compression;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CGSMSNDCP_header_compression")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt8$(mSNDCP_header_compression)))
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

            mSNDCP_header_compression = parcel.ReadUInt8$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CGSMSNDCP_header_compression info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSNDCP_header_compression = info.mSNDCP_header_compression;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSNDCP_header_compression = null;
    }

    public String ToString()
    {
        if (mSNDCP_header_compression == null)
            return "";
        else
            return String.format("%s", mSNDCP_header_compression);
    }

    public String GetTypeName()
    {
        return "Models.CGSMSNDCP_header_compression";
    }
}
